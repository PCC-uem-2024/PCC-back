package br.uem.backendspringboot.controller;

import br.uem.backendspringboot.dto.request.SolicitacaoPostDTO;
import br.uem.backendspringboot.model.Solicitacao;
import br.uem.backendspringboot.service.SolicitacaoService;
import br.uem.backendspringboot.util.converter.dto.ConverterSolicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService solicitacaoService;

    @PostMapping
    public ResponseEntity<Solicitacao> create(@RequestBody SolicitacaoPostDTO solicitacao) {
        Solicitacao solicitation =ConverterSolicitacao.convertSolicitacao(solicitacao);
        solicitation = solicitacaoService.save(solicitation, solicitacao.getIdAluno());
        return ResponseEntity.ok( solicitation);
    }

}
