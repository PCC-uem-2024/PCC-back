package br.uem.backendspringboot.service;

import br.uem.backendspringboot.model.Aluno;
import br.uem.backendspringboot.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
}
