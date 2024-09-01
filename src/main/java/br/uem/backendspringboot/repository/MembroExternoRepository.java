package br.uem.backendspringboot.repository;

import br.uem.backendspringboot.model.MembroExterno;
import br.uem.backendspringboot.model.keys.DefesaExterna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroExternoRepository extends JpaRepository<MembroExterno, DefesaExterna> {
}
