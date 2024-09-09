package br.uem.backendspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    @CPF
    private String cpf;
    private String matricula;
    private LocalDate dataIngresso;

    @OneToMany(mappedBy = "professor")
    @Fetch(FetchMode.JOIN)
    private Set<MembroInterno> defesaInterno = new HashSet<>();

    @OneToMany(mappedBy = "professor")
    @Fetch(FetchMode.JOIN)
    private Set<OrientadorInterno> orientacoes = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario;

}
