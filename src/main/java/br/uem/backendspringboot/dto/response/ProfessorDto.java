package br.uem.backendspringboot.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ProfessorDto {

    private String nome;
    private String email;
    private String cpf;
    private String matricula;
    private String dataIngresso;
    private Long id;
}
