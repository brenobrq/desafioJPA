package br.com.edusync.desafioJPA.Controllers;

import br.com.edusync.desafioJPA.Models.EstoqueModel;
import br.com.edusync.desafioJPA.Models.FuncionarioModel;
import br.com.edusync.desafioJPA.Models.ProdutoModel;
import br.com.edusync.desafioJPA.Services.EstoqueService;
import br.com.edusync.desafioJPA.Services.FuncionarioService;
import br.com.edusync.desafioJPA.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    @Autowired
    private EstoqueService estoqueService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping(value = "/adicionar")
    public ResponseEntity estoqueNovo(@RequestBody EstoqueModel estoqueModel, @RequestParam Integer pId, @RequestParam Integer fId) {
        FuncionarioModel funcionario = funcionarioService.buscarCodigo(fId);
        ProdutoModel produto = produtoService.buscarCodigo(pId);
        estoqueModel.setProduto(produto);
        estoqueModel.setFuncionario(funcionario);
        estoqueService.adicionar(estoqueModel);
        return new ResponseEntity(estoqueModel, HttpStatus.CREATED);
    }

    @GetMapping(value = "/listar")
    public ResponseEntity listarTodosEstoques(){
        return new ResponseEntity(estoqueService.listarTudo(), HttpStatus.OK);
    }



    @DeleteMapping(value = "/deletar")
    public ResponseEntity deletar(@PathVariable Integer codigo) {
        estoqueService.remover(codigo);
        return new ResponseEntity(HttpStatus.OK);


    }

    @PutMapping(value = "/atualizarestoque/{codigo}")
    public ResponseEntity atualizarEstoque(@PathVariable Integer codigo, @RequestBody EstoqueModel estoqueModel){
        estoqueService.update(codigo, estoqueModel);
        return new ResponseEntity(codigo, HttpStatus.OK);
    }
    @GetMapping(value ="/listarHistorico/{Id}")
    public ResponseEntity listarHistoricoDeMovimento(@PathVariable Integer Id){
        return new ResponseEntity(estoqueService.listarHistorico(Id), HttpStatus.OK);

    }
}
