package br.uem.backendspringboot.service;

import br.uem.backendspringboot.dto.request.ProfessorChangeRequestDto;
import br.uem.backendspringboot.dto.request.ProfessorRequestDto;
import br.uem.backendspringboot.exception.NotFoundException;
import br.uem.backendspringboot.model.Professor;
import br.uem.backendspringboot.model.Usuario;
import br.uem.backendspringboot.model.enums.Role;
import br.uem.backendspringboot.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class)
    public Professor save(ProfessorRequestDto professorDto) {
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

        try {
            professor = professorRepository.save(professor);
        } catch (TypeNotPresentException tp) {
            System.out.println("Erro de tipagem: " + tp.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao criar usuario: " + e.getMessage(), e);
        }

        return professor;
    }

    public Professor update(ProfessorChangeRequestDto professorDto, Long id) {
        Professor professor = findById(id);
        professor.setNome(professorDto.getNome());
        professor.setEmail(professorDto.getEmail());
        professor.setCpf(professorDto.getCpf());
        professor.setDataIngresso(professorDto.getIngresso());
        professor.setMatricula(professorDto.getMatricula());

        return professorRepository.save(professor);
    }

    public Boolean professorExists(String email) {
        return professorRepository.findByEmail(email).isPresent();
    }

    public List<Professor> findByNomeContains(String prefixo) {
        try {
            return professorRepository.findByNomeContainsIgnoreCase(prefixo);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao buscar professor: " + e.getMessage(), e);
        }
    }

    public Professor findById(Long idParam) {
        try {
            return professorRepository.findById(idParam).orElseThrow(() -> new NotFoundException("Professor não encontrado!"));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao buscar professor: " + e.getMessage(), e);
        }
    }

    public Professor findByEmail(String emailParam) {
        try {
            return professorRepository.findByEmail(emailParam).orElseThrow(() -> new NotFoundException("Professor não encontrado!"));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao buscar professor: " + e.getMessage(), e);
        }
    }
}
