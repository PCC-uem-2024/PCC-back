package br.uem.backendspringboot.service;

import br.uem.backendspringboot.model.Professor;
import br.uem.backendspringboot.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

}
