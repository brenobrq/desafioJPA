package br.com.edusync.desafioJPA.Repositories;

import br.com.edusync.desafioJPA.Models.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Integer> {
}
