package br.uem.backendspringboot.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponseDto {
    private String token;
    private String refreshToken;
    private String email;
    private String role;
}
