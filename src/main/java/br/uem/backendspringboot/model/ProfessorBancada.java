package br.uem.backendspringboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProfessorBancada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String instituicao;

    @Column(columnDefinition = "boolean default false")
    private boolean externo;

    @ManyToMany(mappedBy = "membros")
    private Set<Solicitacao> solicitacoes = new HashSet<>();
}