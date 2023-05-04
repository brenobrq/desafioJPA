package br.com.edusync.desafioJPA.Controllers;

import br.com.edusync.desafioJPA.Models.FuncionarioModel;
import br.com.edusync.desafioJPA.Services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping(value = "/adicionar")
    public ResponseEntity novoFuncionario(@RequestBody FuncionarioModel funcionarioModel) {
        funcionarioService.adicionar(funcionarioModel);
        return new ResponseEntity(funcionarioModel, HttpStatus.CREATED);
    }

    @GetMapping(value = "/funcionario/listar")
    public ResponseEntity listarTodosFuncionario(Integer codigo) {
        return new ResponseEntity(funcionarioService.buscarCodigo(codigo), HttpStatus.OK);
    }

    @DeleteMapping(value = "/funcionario/delete")
    public ResponseEntity deletar(@PathVariable Integer codigo) {
        funcionarioService.remover(codigo);
        return new ResponseEntity(HttpStatus.OK);


    }


    @PutMapping(value = "/atualizar/{codigo}")
    public ResponseEntity atualizarFuncionario(@PathVariable Integer codigo, @RequestBody FuncionarioModel funcionarioModel){
        funcionarioService.update(codigo, funcionarioModel);
        return new ResponseEntity("Funcionario " + codigo + " atualizado com sucesso!", HttpStatus.OK);
    }
}

