package br.uem.backendspringboot.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
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

    @OneToMany(mappedBy = "professor")
    private Set<MembroExterno> defesaInterno = new HashSet<>();

    @OneToMany(mappedBy = "professor")
    private Set<SuplenteExterno> suplenteInterno = new HashSet<>();

    @OneToMany(mappedBy = "professor")
    private Set<OrientadorExterno> orientacoes = new HashSet<>();
}
