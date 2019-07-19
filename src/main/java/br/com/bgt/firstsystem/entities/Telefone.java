package br.com.bgt.firstsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.bgt.firstsystem.entities.enums.EnumStatus;
import br.com.bgt.firstsystem.entities.enums.EnumTelefone;

@Entity
@Table(name = "telefone")
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_mensalista", nullable = false)
	private Mensalista idMensalista;

	@Column(name = "numero", length = 11, nullable = false)
	private String numero;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "tipoTelefone", nullable = false)
	private EnumTelefone tipoTelefone;

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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public EnumTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(EnumTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", idMensalista=" + idMensalista + ", numero=" + numero + ", tipoTelefone="
				+ tipoTelefone + ", status=" + status + "]";
	}

}
