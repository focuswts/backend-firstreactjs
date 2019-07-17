package br.com.bgt.firstsystem.entities.enums;

public enum EnumStatus {

	ATIVO("ATIVO"), INATIVO("INATIVO");

	private String status;

	EnumStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}
	
}
