package br.uem.backendspringboot.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @Fetch(FetchMode.JOIN)
    private Set<MembroExterno> defesaInterno = new HashSet<>();

    @OneToMany(mappedBy = "professor")
    @Fetch(FetchMode.JOIN)
    private Set<OrientadorExterno> orientacoes = new HashSet<>();
}
