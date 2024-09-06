package br.uem.backendspringboot.service;

import br.uem.backendspringboot.dto.NewAlunoDto;
import br.uem.backendspringboot.exception.MismatchPasswordException;
import br.uem.backendspringboot.model.Aluno;
import br.uem.backendspringboot.model.Usuario;
import br.uem.backendspringboot.model.enums.Role;
import br.uem.backendspringboot.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(rollbackFor = Exception.class)
    public Aluno save(NewAlunoDto alunoDto) {
        if (!usuarioService.matchNewPassword(alunoDto.getPassword(), alunoDto.getConfirmPassword())) {
            throw new MismatchPasswordException("A senha e a confirmação da senha são diferentes.");
        }
        Usuario user = new Usuario();
        user.setTipoUsuario('A');
        user.setSenha(passwordEncoder.encode(alunoDto.getPassword()));
        user.setEmail(alunoDto.getEmail());
        user.getRoles().add(Role.ROLE_ALUNO);
        switch (alunoDto.getTipoCurso()) {
            case MESTRADO -> user.getRoles().add(Role.ROLE_MESTRADO);
            case DOUTORADO -> user.getRoles().add(Role.ROLE_DOUTORADO);
        }
        user = usuarioService.create(user);

        Aluno aluno = new Aluno();
        aluno.setNome(alunoDto.getNome());
        aluno.setEmail(alunoDto.getEmail());
        aluno.setCpf(alunoDto.getCpf());
        aluno.setDataIngresso(alunoDto.getIngresso());
        aluno.setUsuario(user);
        return alunoRepository.save(aluno);
    }
}
