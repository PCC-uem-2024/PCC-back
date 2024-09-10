package br.uem.backendspringboot.model;

import br.uem.backendspringboot.model.enums.TipoAnexo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="solicitacao_id", nullable=false)
    private Solicitacao solicitacao;
}