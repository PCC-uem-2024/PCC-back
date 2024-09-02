package br.uem.backendspringboot.repository;

import br.uem.backendspringboot.model.OrientadorInterno;
import br.uem.backendspringboot.model.keys.ProfessorInterno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrientadorInternoRepository extends JpaRepository<OrientadorInterno, ProfessorInterno> {
}
