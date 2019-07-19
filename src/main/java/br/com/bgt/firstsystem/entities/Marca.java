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
@Table(name = "marca")
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "marca", nullable = false, length = 45)
	private String marca;

	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private EnumStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Marca [id=" + id + ", marca=" + marca + ", status=" + status + "]";
	}

}
