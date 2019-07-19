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
@Table(name = "tabela_preco")
public class TabelaPreco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "valor", nullable = false)
	private double valor;

	@Column(name = "tempo_min", nullable = false)
	private int tempoMin;

	@Column(name = "tempo_max", nullable = false)
	private int tempoMax;

	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private EnumStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getTempoMin() {
		return tempoMin;
	}

	public void setTempoMin(int tempoMin) {
		this.tempoMin = tempoMin;
	}

	public int getTempoMax() {
		return tempoMax;
	}

	public void setTempoMax(int tempoMax) {
		this.tempoMax = tempoMax;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TabelaPreco [id=" + id + ", valor=" + valor + ", tempoMin=" + tempoMin + ", tempoMax=" + tempoMax
				+ ", status=" + status + "]";
	}

}
