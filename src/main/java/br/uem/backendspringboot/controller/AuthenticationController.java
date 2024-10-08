package br.uem.backendspringboot.controller;

import br.uem.backendspringboot.dto.request.LoginRequestDto;
import br.uem.backendspringboot.dto.response.LoginResponseDto;
import br.uem.backendspringboot.dto.request.RefreshRequestDto;
import br.uem.backendspringboot.model.Usuario;
import br.uem.backendspringboot.service.AuthenticationService;
import br.uem.backendspringboot.service.JwtService;
import br.uem.backendspringboot.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;
    private final RefreshTokenService refreshTokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginRequestDto loginDto) {
        Usuario authenticatedUser = authenticationService.autenticar(loginDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        String jwtRefreshToken = refreshTokenService.createRefreshToken(authenticatedUser).getToken();
        return ResponseEntity.ok(LoginResponseDto.builder()
                .token(jwtToken)
                .refreshToken(jwtRefreshToken)
                .email(authenticatedUser.getEmail())
                .role(authenticatedUser.getRoles().toString())
                .tipoUser(authenticatedUser.getTipoUsuario())
                .build());
    }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponseDto> refresh(@RequestBody RefreshRequestDto refreshDto) {
        Usuario authenticatedUser = authenticationService.refresh(refreshDto);
        refreshTokenService.deleteByToken(refreshDto.getToken());
        String jwtToken = jwtService.generateToken(authenticatedUser);
        String jwtRefreshToken = refreshTokenService.createRefreshToken(authenticatedUser).getToken();
        return ResponseEntity.ok(LoginResponseDto.builder()
                .token(jwtToken)
                .refreshToken(jwtRefreshToken)
                .email(authenticatedUser.getEmail())
                .role(authenticatedUser.getRoles().toString())
                .build());
    };
}
