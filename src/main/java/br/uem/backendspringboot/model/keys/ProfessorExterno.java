package br.uem.backendspringboot.model.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ProfessorExterno implements Serializable {

    @Column(name = "professor_id")
    private Long professorId;

    @Column(name = "aluno_id")
    private Long alunoId;
}
