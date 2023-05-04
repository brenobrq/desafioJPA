package br.com.edusync.desafioJPA.Repositories.Criteria.impl.Params;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProdutoFilterParam {
    private String descricao;
    private BigDecimal precoVenda;
    private Integer saldoAtual;
}
