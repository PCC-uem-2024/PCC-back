package br.uem.backendspringboot.service;

import br.uem.backendspringboot.model.Secretaria;
import br.uem.backendspringboot.repository.SecretariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecretariaService {

    @Autowired
    private SecretariaRepository secretariaRepository;

    public Secretaria save(Secretaria secretaria) {
        return secretariaRepository.save(secretaria);
    }
}
