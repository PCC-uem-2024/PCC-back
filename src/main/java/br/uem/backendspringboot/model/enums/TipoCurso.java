package br.uem.backendspringboot.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoCurso {
    MESTRADO("Mestrado"),
    DOUTORADO("Doutorado");

    private String curso;
}
