package br.com.edusync.desafioJPA.Repositories;

import br.com.edusync.desafioJPA.Models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer> {
    List<ProdutoModel> findByDescricaoContainingIgnoreCase(String descricao);
}
