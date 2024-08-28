package br.uem.backendspringboot.controller;

import br.uem.backendspringboot.dto.LoginDto;
import br.uem.backendspringboot.dto.LoginResponseDto;
import br.uem.backendspringboot.model.Usuario;
import br.uem.backendspringboot.service.AuthenticationService;
import br.uem.backendspringboot.service.JwtService;
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

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginDto loginDto) {
        Usuario authenticatedUser = authenticationService.autenticar(loginDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        return ResponseEntity.ok(LoginResponseDto.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .build());
    }
}
