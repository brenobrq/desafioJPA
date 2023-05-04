package br.com.edusync.desafioJPA.Services;

import br.com.edusync.desafioJPA.Models.EstoqueModel;
import br.com.edusync.desafioJPA.Repositories.Criteria.impl.EstoqueRepositoryCustomImpl;
import br.com.edusync.desafioJPA.Repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository estoqueRepository;
    @Autowired
    EstoqueRepositoryCustomImpl estoqueRepositoryCustom;
    public void adicionar (EstoqueModel estoqueSalvo) {
        estoqueRepository.save(estoqueSalvo);

    }


    public List<EstoqueModel> listarTudo(){
        return estoqueRepository.findAll();

    }



    public void remover(Integer codigo) {
        if (estoqueRepository.existsById(codigo)) {
            estoqueRepository.deleteById(codigo);
        }

    }


    public void update(Integer codigo, EstoqueModel estoqueMovimento) {
        if (estoqueRepository.existsById(codigo)) {
            estoqueRepository.save(estoqueMovimento);
        }

    }
    public List<EstoqueModel>listarHistorico(Integer Id){
        return estoqueRepositoryCustom.listarHistoricoDeMovimento(Id);
    }
}
