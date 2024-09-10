package br.uem.backendspringboot.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SolicitacaoPostDTO {
    private String titulo;
    private LocalDateTime dataDefesa;
    private String modo;
    private String tipo;
    private Long idAluno;
    private List<ProfessorRequestForSolicitacaoDto> membrosProfessor = new ArrayList<>();
}
