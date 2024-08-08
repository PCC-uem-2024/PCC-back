package br.uem.backendspringboot.model;

import br.uem.backendspringboot.model.enums.TipoAnexo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

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
    private TipoAnexo tipo;

    @ManyToMany(mappedBy = "anexos")
    private Set<Defesa> defesas;

}
