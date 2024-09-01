package br.uem.backendspringboot.repository;

import br.uem.backendspringboot.model.SuplenteExterno;
import br.uem.backendspringboot.model.keys.DefesaExterna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuplenteExternoRepository extends JpaRepository<SuplenteExterno, DefesaExterna> {
}
