package br.com.edusync.desafioJPA.Repositories.Criteria;

import br.com.edusync.desafioJPA.Models.EstoqueModel;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EstoqueRepositoryCustom {
    List<EstoqueModel> listarHistoricoDeMovimento(Integer Id);
}

