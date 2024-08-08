package br.uem.backendspringboot.repository;

import br.uem.backendspringboot.model.Defesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefesaRepository extends JpaRepository<Defesa, Integer> {
}
