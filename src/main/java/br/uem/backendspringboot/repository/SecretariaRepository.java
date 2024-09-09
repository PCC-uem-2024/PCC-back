package br.uem.backendspringboot.repository;

import br.uem.backendspringboot.model.Secretaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecretariaRepository extends JpaRepository<Secretaria, Long> {

    Optional<Secretaria> findByEmail(String email);

    @Query(value = "SELECT p.nome, p.email, p.cpf, p.matricula, p.data_ingresso, p.id " +
            "FROM Secretaria p LEFT JOIN Usuario u " +
            "ON p.email = u.email " +
            "WHERE p.email LIKE :email",
            nativeQuery = true)
    Object findSecretariaByEmail(@Param("email") String email);

    @Query(value = "SELECT p.nome, p.email, p.cpf, p.matricula, p.data_ingresso, p.id " +
            "FROM Secretaria p LEFT JOIN Usuario u " +
            "ON p.email = u.email " +
            "WHERE p.id = :id",
            nativeQuery = true)
    Object findSecretariaById(@Param("id") Long id);
}
