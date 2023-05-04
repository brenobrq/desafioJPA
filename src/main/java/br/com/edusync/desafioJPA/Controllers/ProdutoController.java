package br.com.edusync.desafioJPA.Controllers;

import br.com.edusync.desafioJPA.Models.ProdutoModel;
import br.com.edusync.desafioJPA.Repositories.Criteria.impl.Params.ProdutoFilterParam;
import br.com.edusync.desafioJPA.Services.ProdutoService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping(value = "/adicionar")
    public ResponseEntity novoProduto(@RequestBody ProdutoModel produto) {
        return new ResponseEntity(produto, HttpStatus.CREATED);
    }


    @GetMapping(value ="/listarProdutosPositivos/{Id}")
    public ResponseEntity listarProdutosPositivos(@PathVariable Integer Id){
        return new ResponseEntity(produtoService.listarPositivos(Id), HttpStatus.OK);

    }

    @GetMapping(value = "/listar")
    public ResponseEntity listarProduto() {
        return new ResponseEntity(produtoService.listarTudo(), HttpStatus.OK);
    }
    @GetMapping(value = "/nome/{busca}")
    public ResponseEntity listarPorNome(@RequestParam(defaultValue = "") String busca) {
        return new ResponseEntity(produtoService.listarPorNome(busca), HttpStatus.OK);
    }

    @PutMapping(value = "/atualizarproduto/{codigo}")
    public ResponseEntity update(@PathVariable Integer codigo, @RequestBody ProdutoModel produto) {
        produtoService.update(codigo, produto);
        return new ResponseEntity("Produto " + codigo + " atualizado", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletar/{codigo}")
    public ResponseEntity deletar(@PathVariable Integer codigo) {
        produtoService.remover(codigo);
        return new ResponseEntity("Produto " + codigo + " deletado com sucesso!", HttpStatus.OK);
    }

    @GetMapping(value = "/filtrar")
    public ResponseEntity filtrar(ProdutoFilterParam param) {
        return new ResponseEntity(produtoService.filtrar(param), HttpStatus.OK);

    }



    @GetMapping(value = "/filtrarprodutoscadastrados")
    public ResponseEntity filtrarProdutosCadastrados(@RequestParam(required = false) String descricao, @RequestParam(required = false) BigDecimal precoVenda, @RequestParam(required = false) Integer saldoAtual) {


        return new ResponseEntity(produtoService.filtrar(new ProdutoFilterParam()), HttpStatus.OK);
    }
}
