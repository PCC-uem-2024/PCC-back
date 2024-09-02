package br.uem.backendspringboot.model;

import br.uem.backendspringboot.model.keys.ProfessorExterno;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrientadorExterno {

    @EmbeddedId
    private ProfessorExterno id;

    @ManyToOne
    @MapsId("professorId")
    @JoinColumn(name = "professor_id")
    private Externo professor;

    @ManyToOne
    @MapsId("alunoId")
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    private Boolean orientador;

}
