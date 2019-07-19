package br.com.bgt.firstsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.bgt.firstsystem.entities.enums.EnumStatus;

@Entity
@Table(name = "tipo_veiculo")
public class TipoVeiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "tipo", nullable = false, length = 45)
	private String tipo;

	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private EnumStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TipoVeiculo [id=" + id + ", tipo=" + tipo + ", status=" + status + "]";
	}

}
