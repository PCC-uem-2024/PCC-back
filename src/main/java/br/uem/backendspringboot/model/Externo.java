package br.uem.backendspringboot.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "professor")
    private Set<MembroExterno> defesaInterno = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "professor")
    private Set<OrientadorExterno> orientacoes = new HashSet<>();
}
