package br.uem.backendspringboot.repository;

import br.uem.backendspringboot.model.PCC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PCCRepository extends JpaRepository<PCC, Integer> {
}
