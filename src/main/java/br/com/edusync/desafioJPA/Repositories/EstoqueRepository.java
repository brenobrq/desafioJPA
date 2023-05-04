package br.com.edusync.desafioJPA.Repositories;

import br.com.edusync.desafioJPA.Models.EstoqueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueModel, Integer> {
}
