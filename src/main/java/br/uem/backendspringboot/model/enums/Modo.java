package br.uem.backendspringboot.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Modo {
    PRESENCIAL("Presencial"),
    REMOTO("Remoto"),
    HIBRIDO("Hibrido");

    private String modo;

    public boolean isRemoto(){
        return REMOTO.equals(this);
    }
}
