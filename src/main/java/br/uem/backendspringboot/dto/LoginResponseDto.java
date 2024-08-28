package br.uem.backendspringboot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponseDto {
    private String token;
    private long expiresIn;
}
