package br.uem.backendspringboot.service;

import br.uem.backendspringboot.dto.LoginDto;
import br.uem.backendspringboot.dto.RefreshDto;
import br.uem.backendspringboot.exception.NotFoundException;
import br.uem.backendspringboot.model.Usuario;
import br.uem.backendspringboot.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UsuarioRepository usuarioRepository;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;

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

    public Usuario refresh(RefreshDto refresh) {
        String token = refresh.getToken();

        if (refreshTokenService.findByToken(token).isEmpty()) {
            throw new NotFoundException("Refresh Token Invalid!");
        }

        String username = jwtService.extractUsername(token);
        if (jwtService.isTokenValid(token, userDetailsService.loadUserByUsername(username))) {
            return usuarioRepository.findByEmail(jwtService.extractUsername(token))
                    .orElseThrow();
        }

        throw new NotFoundException("Invalid Token or User");
    }
}
