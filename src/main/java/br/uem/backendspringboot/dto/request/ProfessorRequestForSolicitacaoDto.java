package br.uem.backendspringboot.dto.request;

import br.uem.backendspringboot.model.Solicitacao;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProfessorRequestForSolicitacaoDto {

    private String nome;
    private String email;
    private String instituicao;
    private boolean externo;
}
