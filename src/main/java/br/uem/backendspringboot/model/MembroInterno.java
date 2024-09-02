package br.uem.backendspringboot.model;

import br.uem.backendspringboot.model.keys.DefesaInterna;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MembroInterno {

    @EmbeddedId
    private DefesaInterna id;

    @ManyToOne
    @MapsId("professorId")
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @MapsId("defesaId")
    @JoinColumn(name = "defesa_id")
    private Defesa defesa;

    private Boolean copiaImpresa;

    private Boolean suplente;

}
