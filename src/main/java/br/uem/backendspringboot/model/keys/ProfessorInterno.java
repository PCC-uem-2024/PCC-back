package br.uem.backendspringboot.model.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ProfessorInterno implements Serializable {

    @Column(name = "professor_id")
    private Long professorId;

    @Column(name = "aluno_id")
    private Long alunoId;

}
