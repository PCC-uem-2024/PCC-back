package br.uem.backendspringboot.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoAnexo {
    TRABALHO("Texto do Trabalho"),
    LATTES("Currículo Lattes"),
    PUBLICACAO("Comprovante de Publicação"),
    MEMBROES("Currículo de Membro"),
    OUTROS("Outros");

    private String anexo;
}
