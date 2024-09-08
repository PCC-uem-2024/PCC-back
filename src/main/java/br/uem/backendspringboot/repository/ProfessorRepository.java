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

    @Query(value = "SELECT p.nome, p.email, p.cpf, p.matricula, p.data_ingresso, p.id " +
            "FROM Professor p LEFT JOIN Usuario u " +
            "ON p.email = u.email " +
            "WHERE p.email LIKE :email",
            nativeQuery = true)
    Object findProfessorByEmail(@Param("email") String email);

    @Query(value = "SELECT p.nome, p.email, p.cpf, p.matricula, p.data_ingresso, p.id " +
            "FROM Professor p LEFT JOIN Usuario u " +
            "ON p.email = u.email " +
            "WHERE p.id = :id",
            nativeQuery = true)
    Object findProfessorById(@Param("id") Long id);

    @Query(value = "SELECT p.nome, p.email, p.cpf, p.matricula, p.data_ingresso, p.id " +
            "FROM Professor p LEFT JOIN Usuario u " +
            "ON p.email = u.email " +
            "WHERE UPPER(p.nome) LIKE :prefixo%",
            nativeQuery = true)
    List<Object[]> findByNomeStartsWith(@Param("prefixo") String prefixo);

}
