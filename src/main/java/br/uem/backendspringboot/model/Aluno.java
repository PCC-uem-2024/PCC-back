package br.uem.backendspringboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @CPF
    private String cpf;
    private String email;
    private LocalDate dataIngresso;

    @OneToMany(mappedBy = "aluno")
    @Fetch(FetchMode.JOIN)
    private Set<OrientadorInterno> orientadoresInterno = new HashSet<>();

    @OneToMany(mappedBy = "aluno")
    @Fetch(FetchMode.JOIN)
    private Set<OrientadorExterno> orientadoresExterno = new HashSet<>();

    @OneToMany(mappedBy = "aluno")
    @Fetch(FetchMode.JOIN)
    private Set<Defesa> defesas = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
