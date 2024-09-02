package br.uem.backendspringboot.repository;

import br.uem.backendspringboot.model.OrientadorExterno;
import br.uem.backendspringboot.model.keys.ProfessorExterno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrientadorExternoRepository extends JpaRepository<OrientadorExterno, ProfessorExterno> {
}
