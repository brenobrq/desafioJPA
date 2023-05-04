package br.com.edusync.desafioJPA.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

    @Data
    @Entity(name = "tb_estoque")
    public class EstoqueModel {
        @Id
        private Integer codigo;

        private Date dataHora;

        @Column(length = 1, name = "tipo_movimento")
        private String tipoMovimento;

        private Integer quantidade;
        @ManyToOne
        @JoinColumn(name = "funcionario_id")
        private FuncionarioModel funcionario;
        @ManyToOne
        @JoinColumn(name = "produto_id")
        private ProdutoModel produto;
     }

