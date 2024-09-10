package br.uem.backendspringboot.service;

import br.uem.backendspringboot.dto.request.ProfessorChangeRequestDto;
import br.uem.backendspringboot.dto.request.ProfessorRequestDto;
import br.uem.backendspringboot.exception.NotFoundException;
import br.uem.backendspringboot.model.Professor;
import br.uem.backendspringboot.model.ProfessorBancada;
import br.uem.backendspringboot.model.Usuario;
import br.uem.backendspringboot.model.enums.Role;
import br.uem.backendspringboot.repository.ProfessorBancadaRepository;
import br.uem.backendspringboot.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorBancadaService {

    @Autowired
    private ProfessorBancadaRepository professorBancadaRepository;


    @Transactional(rollbackFor = Exception.class)
    public ProfessorBancada save(ProfessorBancada professor) {

        return professorBancadaRepository.save(professor);
    }

    public Boolean professorExists(String email) {
        return professorBancadaRepository.findByEmail(email).isPresent();
    }

}
