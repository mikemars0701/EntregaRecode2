package com.spacebook.model;

import java.time.LocalDateTime;

public class Viagem {
	
	private int idViagem;
	
	private LocalDateTime dataViagem;
	
	private String destinoViagem;
	
	private Passageiro passageiro;
	
	private Piloto piloto;


	public int getIdViagem() {
		return idViagem;
	}

	public void setIdViagem(int idViagem) {
		this.idViagem = idViagem;
	}

	public String getDestinoViagem() {
		return destinoViagem;
	}

	public void setDestinoViagem(String destinoViagem) {
		this.destinoViagem = destinoViagem;
	}


	public LocalDateTime getDataViagem() {
		return dataViagem;
	}

	public void setDataViagem(LocalDateTime dataViagem) {
		this.dataViagem = dataViagem;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}

	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}
	
	
	
	
	
	
}
