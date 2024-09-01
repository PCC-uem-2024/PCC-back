package br.uem.backendspringboot.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    ROLE_SECRETARIA("Secretaria"),
    ROLE_COORDENADOR("Coordenador"),
    ROLE_PROFESSOR("Professor"),
    ROLE_ALUNO("Aluno");

    private final String role;
}
