package br.com.bgt.firstsystem.entities.enums;

public enum EnumRoles {

	ADM("ADM"), FUNCIONARIO("FUNCIONARIO");

	private String role;

	EnumRoles(String role) {
		this.role = role;
	}

	public String getRoles() {
		return this.role;
	}

}
