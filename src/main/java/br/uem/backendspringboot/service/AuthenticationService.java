package br.uem.backendspringboot.service;

import br.uem.backendspringboot.dto.LoginDto;
import br.uem.backendspringboot.model.Usuario;
import br.uem.backendspringboot.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public Usuario autenticar(LoginDto login) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getEmail(),
                        login.getPassword()
                )
        );

        return usuarioRepository.findByEmail(login.getEmail())
                .orElseThrow();
    }
}
