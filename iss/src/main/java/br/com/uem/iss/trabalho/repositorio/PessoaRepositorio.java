package br.com.uem.iss.trabalho.repositorio;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.uem.iss.trabalho.modelo.Pessoa;

public interface PessoaRepositorio extends CrudRepository<Pessoa, Integer>, JpaSpecificationExecutor<Pessoa>{

}
