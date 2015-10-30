package br.com.uem.iss.trabalho.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@SuppressWarnings("serial")
@Entity
@Table(name="pessoa" )
public class Pessoa  implements Serializable{

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod;
	@NotNull @NotEmpty
	@Column(name="nome", nullable=false, length=128)
	private String nome;
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="data_cadastro", nullable=false)
	private DateTime  dataCadatro;
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="data_nascimento", nullable=false)
	private DateTime  dataNascimento;
	@Column(name="nome", nullable=false, length=128)
	private String contato;
	@Column
	private Integer ativo;
	  
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="endereco_id", updatable=true, insertable=true, nullable=true)
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.ALL)
	private Endereco endereco;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="telefone_id", updatable=true, insertable=true, nullable=true)
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.ALL)
	private Telefone telefone;
	  
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="email_id", updatable=true, insertable=true, nullable=true)
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.ALL)
	private Email email;
	  
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tipopessoa_id", updatable=true, insertable=true, nullable=true)
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.ALL)
	private TipoPessoa tipopessoa;

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public DateTime getDataCadatro() {
		return dataCadatro;
	}

	public void setDataCadatro(DateTime dataCadatro) {
		this.dataCadatro = dataCadatro;
	}

	public DateTime getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(DateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public TipoPessoa getTipopessoa() {
		return tipopessoa;
	}

	public void setTipopessoa(TipoPessoa tipopessoa) {
		this.tipopessoa = tipopessoa;
	}
	  
	  
}
