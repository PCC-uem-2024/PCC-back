package br.uem.backendspringboot.repository;

import br.uem.backendspringboot.dto.response.ProfessorDto;
import br.uem.backendspringboot.model.Professor;
import br.uem.backendspringboot.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Optional<Professor> findByEmail(String email);
    List<Professor> findByNomeContainsIgnoreCase(String nome);

}
