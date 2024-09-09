package br.uem.backendspringboot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Secretaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    @CPF
    private String cpf;
    private String matricula;
    private LocalDate dataIngresso;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
