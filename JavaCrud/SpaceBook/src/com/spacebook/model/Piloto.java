package com.spacebook.model;

public class Piloto {

	private int idPiloto;
	
	private String nomePiloto;
	
	private String especialidadePiloto;
	
	private String certificacaoPiloto;

	
	


	public Piloto() {
		super();
	}
	
	
	public Piloto(int idPiloto, String nomePiloto, String especialidadePiloto, String certificacaoPiloto) {
		super();
		this.idPiloto = idPiloto;
		this.nomePiloto = nomePiloto;
		this.especialidadePiloto = especialidadePiloto;
		this.certificacaoPiloto = certificacaoPiloto;
	}

	public int getidPiloto() {
		return idPiloto;
	}

	public void setidPiloto(int idPiloto) {
		this.idPiloto = idPiloto;
	}

	public String getnomePiloto() {
		return nomePiloto;
	}

	public void setnomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}

	public String getespecialidadePiloto() {
		return especialidadePiloto;
	}

	public void setespecialidadePiloto(String especialidadePiloto) {
		this.especialidadePiloto = especialidadePiloto;
	}

	public String getcertificacaoPiloto() {
		return certificacaoPiloto;
	}

	public void setcertificacaoPiloto(String certificacaoPiloto) {
		this.certificacaoPiloto = certificacaoPiloto;
	}


	
	
}
