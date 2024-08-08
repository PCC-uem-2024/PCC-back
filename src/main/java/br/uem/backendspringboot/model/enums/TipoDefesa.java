package br.uem.backendspringboot.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoDefesa {
    QUALIFICACAOMESTRADO("Qualificação de Mestrado"),
    QUALIFICACAODOUTORADO("Qualificação de Doutorado"),
    DEFESAMESTRADO("Defesa de Dissertação de Mestrado"),
    DEFESADOUTORADO("Defesa de Tese de Doutorado");

    private String defesa;
}
