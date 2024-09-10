package br.uem.backendspringboot.util.converter.dto;

import br.uem.backendspringboot.dto.request.ProfessorRequestForSolicitacaoDto;
import br.uem.backendspringboot.dto.request.SolicitacaoPostDTO;
import br.uem.backendspringboot.model.ProfessorBancada;
import br.uem.backendspringboot.model.Solicitacao;
import br.uem.backendspringboot.model.enums.Modo;
import br.uem.backendspringboot.model.enums.TipoDefesa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConverterSolicitacao {
    public static Solicitacao convertSolicitacao(SolicitacaoPostDTO solicitacaoPostDTO) {

        List<ProfessorRequestForSolicitacaoDto> membrosProfessor = solicitacaoPostDTO.getMembrosProfessor();
        Set<ProfessorBancada> professors = new HashSet<>();

        membrosProfessor.forEach(professorDTO -> {
            ProfessorBancada professor = new ProfessorBancada();
            professor.setNome(professorDTO.getNome());
            professor.setEmail(professorDTO.getEmail());
            professor.setExterno(true);
            professor.setInstituicao(professorDTO.getInstituicao());
            professors.add(professor);
        });


        return Solicitacao.builder().modo(Modo.valueOf(solicitacaoPostDTO.getModo())).tipo(TipoDefesa.valueOf(solicitacaoPostDTO.getTipo())).titulo(solicitacaoPostDTO.getTitulo()).dataDefesa(solicitacaoPostDTO.getDataDefesa()).membros(professors).build();
    }
}
