package br.uem.backendspringboot.service;

import br.uem.backendspringboot.model.RefreshToken;
import br.uem.backendspringboot.model.Usuario;
import br.uem.backendspringboot.repository.RefreshTokenRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;
    @Autowired
    private JwtService jwtService;


    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    @Transactional
    public void removeExpiredTokens() {
        List<RefreshToken> refreshTokens = refreshTokenRepository.findAll();
        for (RefreshToken refreshToken : refreshTokens) {
            if (jwtService.isTokenExpired(refreshToken.getToken()))
                refreshTokenRepository.delete(refreshToken);
        }
    }

    public RefreshToken createRefreshToken(Usuario usuario) {
        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setUsuario(usuario);
        refreshToken.setToken(jwtService.generateRefreshToken(usuario));

        return refreshTokenRepository.save(refreshToken);
    }

    @Transactional
    public void deleteByToken(String token) {
        refreshTokenRepository.deleteByToken(token);
    }
}
