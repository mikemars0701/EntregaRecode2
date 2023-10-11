package com.spacebook.model;

public class Passageiro {

	private int idPassageiro;

	private String emailPassageiro;

	private String senhaPassageiro;

	private String nomePassageiro;

	private String cpfPassageiro;

	private String enderecoPassageiro;

	private String telefonePassageiro;

	public Passageiro() {
		super();
	}

	public Passageiro(String emailPassageiro, String senhaPassageiro, String nomePassageiro, String cpfPassageiro,
			String enderecoPassageiro, String telefonePassageiro) {
		super();
		this.emailPassageiro = emailPassageiro;
		this.senhaPassageiro = senhaPassageiro;
		this.nomePassageiro = nomePassageiro;
		this.cpfPassageiro = cpfPassageiro;
		this.enderecoPassageiro = enderecoPassageiro;
		this.telefonePassageiro = telefonePassageiro;
	}

	public String getemailPassageiro() {
		return emailPassageiro;
	}

	public void setemailPassageiro(String emailPassageiro) {
		this.emailPassageiro = emailPassageiro;
	}

	public String getsenhaPassageiro() {
		return senhaPassageiro;
	}

	public void setsenhaPassageiro(String senhaPassageiro) {
		this.senhaPassageiro = senhaPassageiro;
	}

	public int getidPassageiro() {
		return idPassageiro;
	}

	public void setidPassageiro(int idPassageiro) {
		this.idPassageiro = idPassageiro;
	}

	public String getnomePassageiro() {
		return nomePassageiro;
	}

	public void setnomePassageiro(String nomePassageiro) {
		this.nomePassageiro = nomePassageiro;
	}

	public String getcpfPassageiro() {
		return cpfPassageiro;
	}

	public void setcpfPassageiro(String cpfPassageiro) {
		this.cpfPassageiro = cpfPassageiro;
	}

	public String getenderecoPassageiro() {
		return enderecoPassageiro;
	}

	public void setenderecoPassageiro(String enderecoPassageiro) {
		this.enderecoPassageiro = enderecoPassageiro;
	}

	public String gettelefonePassageiro() {
		return telefonePassageiro;
	}

	public void settelefonePassageiro(String telefonePassageiro) {
		this.telefonePassageiro = telefonePassageiro;
	}

}
