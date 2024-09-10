package br.uem.backendspringboot.controller;

import br.uem.backendspringboot.dto.request.SolicitacaoPostDTO;
import br.uem.backendspringboot.model.Solicitacao;
import br.uem.backendspringboot.service.SolicitacaoService;
import br.uem.backendspringboot.util.converter.dto.ConverterSolicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Solicitacao>> getAll() {
        return ResponseEntity.ok(solicitacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitacao> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(solicitacaoService.findById(id));
    }

    @GetMapping("/aluno/{id}")
    public ResponseEntity<Solicitacao> getByAluno_Id(@PathVariable Long id) {
        return ResponseEntity.ok(solicitacaoService.findByAluno_Id(id));
    }

}
