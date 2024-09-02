package br.uem.backendspringboot.model;

import br.uem.backendspringboot.model.keys.ProfessorInterno;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrientadorInterno {

    @EmbeddedId
    private ProfessorInterno id;

    @ManyToOne
    @MapsId("professorId")
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @MapsId("alunoId")
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    private Boolean orientador;

}
