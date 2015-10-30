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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name="endereco" )
public class Endereco implements Serializable {
	  
	@Id
	@Column(name="endereco_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull @NotEmpty
	@Column(name="rua", nullable=false, length=128)
	private String rua;
	@NotNull @NotEmpty
	@Column(name="numero", nullable=false, length=10)
	private String numero;
	
	@Column(name="complemento", nullable=false, length=128)
	private String complemento;
	@NotNull @NotEmpty
	@Column(name="bairro", nullable=false, length=40)
	private String bairro;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cidade_id", updatable=true, insertable=true, nullable=true)
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.ALL)
	private Cidade cidade;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tipoendereco_id", updatable=true, insertable=true, nullable=true)
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.ALL)
	private TipoEndereco tipoendereco;
}
