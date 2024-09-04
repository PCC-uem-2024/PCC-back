package br.uem.backendspringboot.dto;

import br.uem.backendspringboot.model.enums.TipoCurso;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class NewAlunoDto {

    private String nome;
    private String cpf;
    private String email;
    private String matricula;
    private LocalDate ingresso;
    @Enumerated(EnumType.STRING)
    private TipoCurso tipoCurso;
    private String password;
    private String confirmPassword;

}
