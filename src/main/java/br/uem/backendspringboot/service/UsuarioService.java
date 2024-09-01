package br.uem.backendspringboot.service;

import br.uem.backendspringboot.model.Usuario;
import br.uem.backendspringboot.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public Boolean matchPassword(String email, String password) {
        return usuarioRepository.findByEmail(email).filter(value -> passwordEncoder.matches(password, value.getSenha())).isPresent();
    }

    public Boolean changePassword(String email, String password) {
        Optional<Usuario> userOpt = usuarioRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            Usuario user = userOpt.get();
            user.setSenha(passwordEncoder.encode(password));
            usuarioRepository.save(user);
            return true;
        } else {
            return false;
        }
    }
}
