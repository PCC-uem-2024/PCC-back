package br.uem.backendspringboot.service;

import br.uem.backendspringboot.dto.request.NewSecretariaDto;
import br.uem.backendspringboot.exception.NotFoundException;
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

@Service
@RequiredArgsConstructor
public class SecretariaService {

    @Autowired
    private SecretariaRepository secretariaRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Boolean secretariaExists(String email) {
        return secretariaRepository.findByEmail(email).isPresent();
    }

    @Transactional(rollbackFor = Exception.class)
    public Secretaria save(NewSecretariaDto secretariaDto) {
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

        try {
            secretaria = secretariaRepository.save(secretaria);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao criar usuario: " + e.getMessage(), e);
        }
        return secretaria;
    }

    public Secretaria findById(Long idParam) {
        try {
            return secretariaRepository.findById(idParam).orElseThrow(() -> new NotFoundException("Secretarria não encontrado!"));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao buscar professor: " + e.getMessage(), e);
        }
    }

    public Secretaria findByEmail(String emailParam) {
        try {
            return secretariaRepository.findByEmail(emailParam).orElseThrow(() -> new NotFoundException("Secretarria não encontrado!"));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao buscar professor: " + e.getMessage(), e);
        }
    }
}
