package br.uem.backendspringboot.repository;

import br.uem.backendspringboot.model.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Integer> {
    Optional<Solicitacao> findByAluno_Id(Long id);
}
