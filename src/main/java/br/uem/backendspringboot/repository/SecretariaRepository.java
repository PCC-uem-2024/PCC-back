package br.uem.backendspringboot.repository;

import br.uem.backendspringboot.model.Secretaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecretariaRepository extends JpaRepository<Secretaria, Long> {

    Optional<Secretaria> findByEmail(String email);
}
