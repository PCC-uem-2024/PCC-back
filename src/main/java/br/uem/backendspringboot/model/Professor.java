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

    @OneToMany(mappedBy = "professor")
    private Set<MembroInterno> defesaInterno;

    @OneToMany(mappedBy = "professor")
    private Set<SuplenteInterno> suplenteInterno;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
