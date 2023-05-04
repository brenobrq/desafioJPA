package br.com.edusync.desafioJPA.Repositories.Criteria.impl;

import br.com.edusync.desafioJPA.Models.EstoqueModel;
import br.com.edusync.desafioJPA.Repositories.Criteria.EstoqueRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EstoqueRepositoryCustomImpl implements EstoqueRepositoryCustom {
    private EntityManager entityManager;
    public void EstoqueRepsitoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<EstoqueModel> listarHistoricoDeMovimento(Integer Id){
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<EstoqueModel> estoqueMovimentoCriteriaQuery = criteriaBuilder.createQuery(EstoqueModel.class);

        Root<EstoqueModel> produtoRoot = estoqueMovimentoCriteriaQuery.from(EstoqueModel.class);

        estoqueMovimentoCriteriaQuery.select(produtoRoot).where(criteriaBuilder.equal(produtoRoot.get("produto"), Id));

        TypedQuery<EstoqueModel> estoqueMovimentoTypedQuery = this.entityManager.createQuery((estoqueMovimentoCriteriaQuery));

        return estoqueMovimentoTypedQuery.getResultList();

    }
}
