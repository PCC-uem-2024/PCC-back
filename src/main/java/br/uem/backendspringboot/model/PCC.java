package br.uem.backendspringboot.model;

import br.uem.backendspringboot.model.enums.TipoCurso;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class PCC {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataFundacao;
    private String endereco;
    @Enumerated(EnumType.ORDINAL)
    private TipoCurso tipoCurso;

    @JsonIgnore
    @OneToMany
    private Set<Professor> professores = new HashSet<>();
}
