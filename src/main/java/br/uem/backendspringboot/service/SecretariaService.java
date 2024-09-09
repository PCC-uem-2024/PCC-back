package br.uem.backendspringboot.service;

import br.uem.backendspringboot.dto.NewSecretariaDto;
import br.uem.backendspringboot.dto.response.ProfessorDto;
import br.uem.backendspringboot.dto.response.SecretariaDto;
import br.uem.backendspringboot.functions.Conversions;
import br.uem.backendspringboot.model.Professor;
import br.uem.backendspringboot.model.Secretaria;
import br.uem.backendspringboot.model.Usuario;
import br.uem.backendspringboot.model.enums.Role;
import br.uem.backendspringboot.repository.SecretariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;

@Service
@RequiredArgsConstructor
public class SecretariaService {

    @Autowired
    private SecretariaRepository secretariaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Boolean secretariaExists(String email){
        return secretariaRepository.findByEmail(email).isPresent();
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(NewSecretariaDto secretariaDto) {
        try{
            Usuario user = new Usuario();
            user.setTipoUsuario('S');
            user.setSenha(passwordEncoder.encode(secretariaDto.getPassword()));
            user.setEmail(secretariaDto.getEmail());
            user.getRoles().add(Role.ROLE_SECRETARIA);
            user = usuarioService.create(user);

            Secretaria secretaria = new Secretaria();
            secretaria.setCpf(secretariaDto.getCpf());
            secretaria.setNome(secretariaDto.getNome());
            secretaria.setEmail(secretariaDto.getEmail());
            secretaria.setMatricula(secretariaDto.getMatricula());
            secretaria.setDataIngresso(secretariaDto.getDataIngresso());
            secretaria.setUsuario(user);

            secretariaRepository.save(secretaria);

        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao criar usuario: " + e.getMessage(), e);
        }
    }

    public SecretariaDto findById(Long idParam){
        try {
            Object secretaria = secretariaRepository.findSecretariaById(idParam);

            if(secretaria instanceof Object[]){
                SecretariaDto dto;
                Object[] retorno = (Object[]) secretaria;
                Conversions conversions = new Conversions();

                String nome = (String) retorno[0];
                String email = (String) retorno[1];
                String cpf = (String) retorno[2];
                String matricula = (String) retorno[3];
                String dataIngresso =  conversions.dateToString((Date) retorno[4]);
                Long id = (Long) retorno[5];

                dto = new SecretariaDto(nome, email, cpf, matricula, dataIngresso, id);

                return dto;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao buscar professor: " + e.getMessage(), e);
        }
    }

    public SecretariaDto findByEmail(String emailParam){
        try {
            Object secretaria = secretariaRepository.findSecretariaByEmail(emailParam);

            if(secretaria instanceof Object[]){
                SecretariaDto dto;
                Object[] retorno = (Object[]) secretaria;
                Conversions conversions = new Conversions();

                String nome = (String) retorno[0];
                String email = (String) retorno[1];
                String cpf = (String) retorno[2];
                String matricula = (String) retorno[3];
                String dataIngresso =  conversions.dateToString((Date) retorno[4]);
                Long id = (Long) retorno[5];

                dto = new SecretariaDto(nome, email, cpf, matricula, dataIngresso, id);

                return dto;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao buscar professor: " + e.getMessage(), e);
        }
    }
}
