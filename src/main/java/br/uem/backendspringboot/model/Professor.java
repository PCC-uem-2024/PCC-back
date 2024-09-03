package br.uem.backendspringboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    @CPF
    private String cpf;

    @OneToMany(mappedBy = "professor")
    private Set<MembroInterno> defesaInterno = new HashSet<>();

    @OneToMany(mappedBy = "professor")
    private Set<OrientadorInterno> orientacoes = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
