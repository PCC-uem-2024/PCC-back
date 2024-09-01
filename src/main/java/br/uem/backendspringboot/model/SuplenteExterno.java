package br.uem.backendspringboot.model;

import br.uem.backendspringboot.model.keys.DefesaExterna;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class SuplenteExterno {

    @EmbeddedId
    private DefesaExterna id;

    @ManyToOne
    @MapsId("externoId")
    @JoinColumn(name = "externo_id")
    private Externo professor;

    @ManyToOne
    @MapsId("defesaId")
    @JoinColumn(name = "defesa_id")
    private Defesa defesa;

    private Boolean copiaImpresa;
}
