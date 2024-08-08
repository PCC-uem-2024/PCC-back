package br.uem.backendspringboot.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoAnexo {
    TRABALHO("Texto do Trabalho"),
    LATTESEXTERNO("Currículo Lattes de Membro Externo"),
    PUBLICACAO("Comprovante de Publicação"),
    MEMBROESTRANGEIRO("Currículo de Membro Estrangeiro"),
    OUTROS("Outros");

    private String anexo;
}
