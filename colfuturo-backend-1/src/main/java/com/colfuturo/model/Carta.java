package com.colfuturo.model;

public class Carta {
	
	private Integer idCarta;
	private String destino;
	private TipoCarta tipocarta;
	private Persona persona;
	
	
	public Integer getIdCarta() {
		return idCarta;
	}
	public void setIdCarta(Integer idCarta) {
		this.idCarta = idCarta;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public TipoCarta getTipocarta() {
		return tipocarta;
	}
	public void setTipocarta(TipoCarta tipocarta) {
		this.tipocarta = tipocarta;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	


}