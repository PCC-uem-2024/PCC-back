package br.uem.backendspringboot.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SecretariaDto {

    private String nome;
    private String email;
    private String cpf;
    private String matricula;
    private String dataIngresso;
    private Long id;
}
