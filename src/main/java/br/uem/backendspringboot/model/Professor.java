package br.uem.backendspringboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean copiaImpresa;

    @ManyToMany(mappedBy = "membrosInternos")
    private Set<Defesa> defesaInterno;

    @ManyToMany(mappedBy = "suplentesInternos")
    private Set<Defesa> suplenteInterno;

}
