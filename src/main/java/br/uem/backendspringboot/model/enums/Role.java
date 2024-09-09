package br.uem.backendspringboot.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    ROLE_ADMIN("Admin"),
    ROLE_SECRETARIA("Secretaria"),
    ROLE_COORDENADOR("Coordenador"),
    ROLE_PROFESSOR("Professor"),
    ROLE_ALUNO("Aluno"),
    ROLE_MESTRADO("Mestrado"),
    ROLE_DOUTORADO("Doutorado");

    private final String role;
}
