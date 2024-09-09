package br.uem.backendspringboot.model;

import br.uem.backendspringboot.model.enums.TipoAnexo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Anexo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double tamanho;
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoAnexo tipo;
    private Boolean externo;

    @ManyToOne
    @JoinColumn(name = "defesa_id", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Defesa defesa;

}
