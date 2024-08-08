package br.uem.backendspringboot.model;

import br.uem.backendspringboot.model.enums.TipoCurso;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PCC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataFundacao;
    private String endereco;
    @Enumerated(EnumType.ORDINAL)
    private TipoCurso tipoCurso;
}
