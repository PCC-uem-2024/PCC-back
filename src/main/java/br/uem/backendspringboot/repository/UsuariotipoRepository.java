package br.uem.backendspringboot.repository;

import br.uem.backendspringboot.model.UsuarioTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariotipoRepository extends JpaRepository<UsuarioTipo, Long> {
}
