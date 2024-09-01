package br.uem.backendspringboot.model.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class DefesaExterna {

    @Column(name = "externo_id")
    private Long externoId;

    @Column(name = "defesa_id")
    private Long defesaId;
}
