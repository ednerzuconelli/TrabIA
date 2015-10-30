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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@SuppressWarnings("serial")
@Entity
@Table(name="email" )
public class Email implements Serializable {

	@Id
	@Column(name="email_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="email", nullable=false, length=128)
	private String email;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tipoemail_id", updatable=true, insertable=true, nullable=true)
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.ALL)
	private TipoEmail tipoemail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoEmail getTipoemail() {
		return tipoemail;
	}

	public void setTipoemail(TipoEmail tipoemail) {
		this.tipoemail = tipoemail;
	}
	
	
}
