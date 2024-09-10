package br.uem.backendspringboot.repository;

import br.uem.backendspringboot.model.ProfessorBancada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorBancadaRepository extends JpaRepository<ProfessorBancada, Long> {
   Optional<ProfessorBancada> findByEmail(String email);
}
