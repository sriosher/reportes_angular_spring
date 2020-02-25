package com.colfuturo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipocarta")
public class TipoCarta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoCarta;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "idioma", nullable = false, length = 50)
	private String idioma;

	@Column(name = "url", nullable = false)
	private String url;
	
	@Column(name = "contenido", nullable = false)
	private String contenido;

	public Integer getIdTipoCarta() {
		return idTipoCarta;
	}

	public void setIdTipoCarta(Integer idTipoCarta) {
		this.idTipoCarta = idTipoCarta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	





}
