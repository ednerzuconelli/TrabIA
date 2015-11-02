package br.com.uem.iss.trabalho.servico;

import br.com.uem.iss.trabalho.modelo.Pessoa;

public interface PessoaServico {

	public Pessoa getByCod(Integer cod);
	public void save(Pessoa pessoa);
}
