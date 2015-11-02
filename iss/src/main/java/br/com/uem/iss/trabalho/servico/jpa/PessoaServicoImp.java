package br.com.uem.iss.trabalho.servico.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uem.iss.trabalho.modelo.Pessoa;
import br.com.uem.iss.trabalho.repositorio.PessoaRepositorio;
import br.com.uem.iss.trabalho.servico.PessoaServico;

@Service("pessoaServico")
@Repository
@Transactional
public class PessoaServicoImp implements PessoaServico {

	@Autowired
	private PessoaRepositorio pessoaRepositorio;
	
	@Transactional(readOnly=true)
	@Override
	public Pessoa getByCod(Integer cod) {
		// TODO Auto-generated method stub
		return pessoaRepositorio.findOne(cod);
	}
	
	@Transactional
	@Override
	public void save(Pessoa pessoa) {
		pessoaRepositorio.save(pessoa);
		
	}

}
