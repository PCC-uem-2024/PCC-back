package br.uem.backendspringboot.service;

import br.uem.backendspringboot.dto.NewProfessorDto;
import br.uem.backendspringboot.dto.response.ProfessorDto;
import br.uem.backendspringboot.functions.Conversions;
import br.uem.backendspringboot.model.Professor;
import br.uem.backendspringboot.model.Usuario;
import br.uem.backendspringboot.model.enums.Role;
import br.uem.backendspringboot.repository.ProfessorRepository;
import br.uem.backendspringboot.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class)
    public void save(NewProfessorDto professorDto) {
        try {

            Usuario user = new Usuario();
            user.setTipoUsuario('P');
            user.setSenha(passwordEncoder.encode(professorDto.getPassword()));
            user.setEmail(professorDto.getEmail());
            user.getRoles().add(Role.ROLE_PROFESSOR);
            user = usuarioService.create(user);

            Professor professor = new Professor();
            professor.setCpf(professorDto.getCpf());
            professor.setNome(professorDto.getNome());
            professor.setEmail(professorDto.getEmail());
            professor.setMatricula(professorDto.getMatricula());
            professor.setDataIngresso(professorDto.getDataIngresso());
            professor.setUsuario(user);

            professorRepository.save(professor);

        } catch (TypeNotPresentException tp){
            System.out.println("Erro de tipagem: " + tp.getMessage());
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao salvar professor: " + e.getMessage(), e);
        }
    }

    public Boolean professorExists(String email){
        return professorRepository.findByEmail(email).isPresent();
    }

    public List<ProfessorDto> findByNomeStartsWith(String prefixo){
        try {
            List<Object[]> listaProfessores = professorRepository.findByNomeStartsWith(prefixo.toUpperCase());
            List<ProfessorDto> dto = new ArrayList<>();
            Conversions conversions = new Conversions();
            for (Object[] retorno : listaProfessores){
                String nome = (String) retorno[0];
                String email = (String) retorno[1];
                String cpf = (String) retorno[2];
                String matricula = (String) retorno[3];
                String dataIngresso =  conversions.dateToString((Date) retorno[4]);
                Long id = (Long) retorno[5];

                dto.add(new ProfessorDto(nome, email, cpf, matricula, dataIngresso, id));
            }

            return dto;
        }catch (Exception e ){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao buscar professor: " + e.getMessage(), e);
        }
    }

    public ProfessorDto findById(Long idParam){
        try {
            Object professor = professorRepository.findProfessorById(idParam);

            if(professor instanceof Object[]){
                ProfessorDto dto;
                Object[] retorno = (Object[]) professor;
                Conversions conversions = new Conversions();

                String nome = (String) retorno[0];
                String email = (String) retorno[1];
                String cpf = (String) retorno[2];
                String matricula = (String) retorno[3];
                String dataIngresso =  conversions.dateToString((Date) retorno[4]);
                Long id = (Long) retorno[5];

                dto = new ProfessorDto(nome, email, cpf, matricula, dataIngresso, id);

                return dto;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao buscar professor: " + e.getMessage(), e);
        }
    }

    public ProfessorDto findByEmail(String emailParam){
        try {
            Object professor = professorRepository.findProfessorByEmail(emailParam);

            if(professor instanceof Object[]){
                ProfessorDto dto;
                Object[] retorno = (Object[]) professor;
                Conversions conversions = new Conversions();

                String nome = (String) retorno[0];
                String email = (String) retorno[1];
                String cpf = (String) retorno[2];
                String matricula = (String) retorno[3];
                String dataIngresso =  conversions.dateToString((Date) retorno[4]);
                Long id = (Long) retorno[5];

                dto = new ProfessorDto(nome, email, cpf, matricula, dataIngresso, id);

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
