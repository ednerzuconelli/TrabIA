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
@Table(name="telefone" )
public class Telefone implements Serializable {

	@Id
	@Column(name="telefone_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull @NotEmpty
	@Column(name="telefone", nullable=false, length=13)
	private String telefone;
	
}
