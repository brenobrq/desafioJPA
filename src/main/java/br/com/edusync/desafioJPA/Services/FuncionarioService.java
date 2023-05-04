package br.com.edusync.desafioJPA.Services;

import br.com.edusync.desafioJPA.Models.EstoqueModel;
import br.com.edusync.desafioJPA.Models.FuncionarioModel;
import br.com.edusync.desafioJPA.Repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;



    public void adicionar(FuncionarioModel funcionarioSalvo) {
        funcionarioRepository.save(funcionarioSalvo);
    }


    public FuncionarioModel buscarCodigo(Integer codigo) {
        Optional<FuncionarioModel> optionalDeFuncionario = funcionarioRepository.findById(codigo);
        if (optionalDeFuncionario.isPresent()) {
            return optionalDeFuncionario.get();
        }
        return null;
    }


    public void update(Integer codigo, FuncionarioModel funcionarioResponsavel) {
        if (funcionarioRepository.existsById(codigo)){
            funcionarioRepository.save(funcionarioResponsavel);
        }

    }

    public void remover (Integer codigo) {
        if (funcionarioRepository.existsById(codigo)) {
            funcionarioRepository.deleteById(codigo);
        }
    }

}

