package br.com.bgt.firstsystem.entities.enums;

public enum EnumTelefone {

	RESIDENCIAL("RESIDENCIAL"), COMERCIAL("COMERCIAL"), CELULAR("CELULAR");

	private String tipoTel;

	EnumTelefone(String tipoTel) {
		this.tipoTel = tipoTel;
	}

	public String getTipoTel() {
		return this.tipoTel;
	}

}
