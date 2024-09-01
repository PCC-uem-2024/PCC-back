package br.uem.backendspringboot.repository;

import br.uem.backendspringboot.model.MembroInterno;
import br.uem.backendspringboot.model.keys.DefesaInterna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroInternoRepository extends JpaRepository<MembroInterno, DefesaInterna> {
}
