package br.uem.backendspringboot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class NewSecretariaDto {

    private String nome;
    private String cpf;
    private String email;
    private String matricula;
    private LocalDate dataIngresso;
    private String password;

}
