package br.com.edusync.desafioJPA.Services;

import br.com.edusync.desafioJPA.Models.ProdutoModel;
import br.com.edusync.desafioJPA.Repositories.Criteria.impl.Params.ProdutoFilterParam;
import br.com.edusync.desafioJPA.Repositories.Criteria.impl.ProdutoRepositoryCustomImpl;
import br.com.edusync.desafioJPA.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoRepositoryCustomImpl produtoRepositoryCustom;



    public ProdutoModel buscarCodigo(Integer codigo) {
        Optional<ProdutoModel> optionalDeProduto = produtoRepository.findById(codigo);
        if (optionalDeProduto.isPresent()) {
            return optionalDeProduto.get();
        }
        return null;
    }

    public List<ProdutoModel> listarTudo() {

        return produtoRepository.findAll();
    }


    public void update(Integer codigo, ProdutoModel produto) {
        if (produtoRepository.existsById(codigo)) {
            produtoRepository.save(produto);
        }
    }

    public void remover(Integer codigo) {
        if (produtoRepository.existsById(codigo)) {
            produtoRepository.deleteById(codigo);
        }
    }

    public List<ProdutoModel> filtrar(ProdutoFilterParam param) {

        return produtoRepositoryCustom.getFiltro(param);

    }


    public List<ProdutoModel> listarPorNome(String descricaoDaBusca) {
        return produtoRepository.findByDescricaoContainingIgnoreCase(descricaoDaBusca);
    }


    public List<ProdutoModel> listarPositivos(Integer Id){

        return produtoRepositoryCustom.positivo(Id);
      }
}