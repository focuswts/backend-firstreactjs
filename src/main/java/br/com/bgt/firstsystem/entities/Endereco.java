package br.com.bgt.firstsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.bgt.firstsystem.entities.enums.EnumStatus;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@OneToOne
	@JoinColumn(name = "id_mensalista", nullable = false)
	private Mensalista idMensalista;

	@OneToOne
	@JoinColumn(name = "id_cidade", nullable = false)
	private Cidade idCidade;

	@Column(name = "cep", nullable = false, length = 8)
	private String cep;

	@Column(name = "logradouro", nullable = false, length = 100)
	private String logradouro;

	@Column(name = "numero", nullable = false, length = 10)
	private String numero;

	@Column(name = "complemento", nullable = false, length = 100)
	private String complemento;

	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private EnumStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Mensalista getIdMensalista() {
		return idMensalista;
	}

	public void setIdMensalista(Mensalista idMensalista) {
		this.idMensalista = idMensalista;
	}

	public Cidade getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Cidade idCidade) {
		this.idCidade = idCidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", idMensalista=" + idMensalista + ", idCidade=" + idCidade + ", cep=" + cep
				+ ", logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento + ", status="
				+ status + "]";
	}

}
