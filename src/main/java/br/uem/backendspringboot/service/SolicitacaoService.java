package br.uem.backendspringboot.service;

import br.uem.backendspringboot.exception.NotFoundException;
import br.uem.backendspringboot.model.Aluno;
import br.uem.backendspringboot.model.Professor;
import br.uem.backendspringboot.model.ProfessorBancada;
import br.uem.backendspringboot.model.Solicitacao;
import br.uem.backendspringboot.repository.SolicitacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    private ProfessorBancadaService professorBancadaService;


    @Autowired
    private AlunoService alunoService;

    public Solicitacao save(Solicitacao solicitacao, Long idAluno) {

        if(idAluno == null) {
            throw new RuntimeException("Id Aluno is null");
        }

        Aluno aluno = alunoService.findById(idAluno);

        if(aluno == null) {
            throw new RuntimeException("Aluno not found");
        }

        solicitacao.setAluno(aluno);

        Set<ProfessorBancada> professors = new HashSet<>();
        professors.addAll(solicitacao.getMembros());

        solicitacao.setMembros(professors);

        return solicitacaoRepository.save(solicitacao);
    }

    public List<Solicitacao> findAll() {
        return solicitacaoRepository.findAll();
    }

    public Solicitacao findById(Integer id) {
        return solicitacaoRepository.findById(id).orElseThrow(() -> new NotFoundException("Solicitacão não encontrada!"));
    }

    public Solicitacao findByAluno_Id(Long id) {
        return solicitacaoRepository.findByAluno_Id(id).orElseThrow(() -> new NotFoundException("Solicitacões não encontradas!"));
    }
}
