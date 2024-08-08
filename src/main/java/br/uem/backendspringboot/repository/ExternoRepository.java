package br.uem.backendspringboot.repository;

import br.uem.backendspringboot.model.Externo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternoRepository extends JpaRepository<Externo, Integer> {
}
