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
public class Externo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String instituicao;
    private String cpf;

    @ManyToMany(mappedBy = "membrosExternos")
    private Set<Defesa> defesaExterno;

    @ManyToMany(mappedBy = "suplentesExternos")
    private Set<Defesa> suplenteExterno;
}
