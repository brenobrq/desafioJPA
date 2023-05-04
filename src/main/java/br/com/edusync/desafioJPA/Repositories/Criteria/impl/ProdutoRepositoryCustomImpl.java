package br.com.edusync.desafioJPA.Repositories.Criteria.impl;

import br.com.edusync.desafioJPA.Models.ProdutoModel;
import br.com.edusync.desafioJPA.Repositories.Criteria.ProdutoRepositoryCustom;
import br.com.edusync.desafioJPA.Repositories.Criteria.impl.Params.ProdutoFilterParam;
import br.com.edusync.desafioJPA.Repositories.ProdutoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProdutoRepositoryCustomImpl implements ProdutoRepositoryCustom {
    private EntityManager entityManager;

    public ProdutoRepositoryCustomImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public List<ProdutoModel> getFiltro(ProdutoFilterParam param) {
        CriteriaBuilder criteriaBuilder= this.entityManager.getCriteriaBuilder();
        CriteriaQuery<ProdutoModel> query = criteriaBuilder.createQuery(ProdutoModel.class);

        Root<ProdutoModel> produto = query.from(ProdutoModel.class);
        List<Predicate> predicates= new ArrayList<>();
        if (param.getDescricao()!=null){
            predicates.add(criteriaBuilder.like(produto.get("descricao"), "%" + param.getDescricao() + "%"));
        }
        if (param.getPrecoVenda()!=null){
            predicates.add(criteriaBuilder.equal(produto.get("saldoAtual"),"%" + param.getSaldoAtual()+"%"));
        }

        if (param.getPrecoVenda()!=null){
            predicates.add(criteriaBuilder.equal(produto.get("precoVenda"),"%" + param.getPrecoVenda()+"%"));
        }


        if (!predicates.isEmpty()){
            query.where(predicates.stream().toArray(Predicate[]::new));
        }

        TypedQuery<ProdutoModel> queryResult = this.entityManager.createQuery(query);

        return queryResult.getResultList();
    }
    public List<ProdutoModel> positivo(Integer codigo){

        CriteriaBuilder criteriaBuilder =this.entityManager.getCriteriaBuilder();
        CriteriaQuery<ProdutoModel> produtoCriteriaQuery = criteriaBuilder.createQuery(ProdutoModel.class);

        Root<ProdutoModel>produto =produtoCriteriaQuery.from(ProdutoModel.class);

        if (codigo!= null){
            produtoCriteriaQuery.select(produto).where(criteriaBuilder.gt(produto.get("saldoAtual"), 0));
        }
        TypedQuery<ProdutoModel> produtoTypedQuery = this.entityManager.createQuery(produtoCriteriaQuery);
        return produtoTypedQuery.getResultList();
    }
}
