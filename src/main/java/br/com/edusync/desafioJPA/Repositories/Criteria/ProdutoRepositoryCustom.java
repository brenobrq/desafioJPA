package br.com.edusync.desafioJPA.Repositories.Criteria;

import br.com.edusync.desafioJPA.Models.ProdutoModel;
import br.com.edusync.desafioJPA.Repositories.Criteria.impl.Params.ProdutoFilterParam;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProdutoRepositoryCustom {
    List<ProdutoModel> getFiltro(ProdutoFilterParam param);

    List<ProdutoModel> positivo(Integer codigo);
}
