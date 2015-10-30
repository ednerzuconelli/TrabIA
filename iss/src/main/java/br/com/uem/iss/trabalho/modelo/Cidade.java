package br.com.uem.iss.trabalho.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name="cidade" )
public class Cidade implements Serializable {

	@Id
	@Column(name="cidade_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull @NotEmpty
	@Column(name="cidade", nullable=false, length=60)
	private String cidade;
	@NotNull @NotEmpty
	@Column(name="estado", nullable=false, length=2)
	private String estado;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
