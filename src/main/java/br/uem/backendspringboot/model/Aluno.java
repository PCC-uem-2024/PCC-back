package br.uem.backendspringboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataIngresso;
    @ManyToOne
    @JoinColumn(name = "orientador_id")
    private Professor orientador;
    @ManyToOne
    @JoinColumn(name = "coorientador1_id")
    private Professor coorientador1;
    @ManyToOne
    @JoinColumn(name = "coorientador2_id")
    private Professor coorientador2;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
