package com.colfuturo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;
	
	@Column(name = "nombres", nullable = false, length = 50)
	private String nombres;
	

	@Column(name = "apellidos", nullable = false, length = 50)
	private String apellidos;
	
	@Column(name = "cargo", nullable = false, length = 50)
	private String cargo;
	
	@Column(name = "organizacion", nullable = false, length = 50)
	private String organizacion;
	
	@Column(name = "direccion", nullable = false)
	private String direccion;
	
	@Column(name = "detalles", nullable = false, length = 50)
	private String detalles;
	
	@Column(name = "ciudad", nullable = false, length = 50)
	private String ciudad;
	
	@Column(name = "pais", nullable = false, length = 50)
	private String pais;

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(String organizacion) {
		this.organizacion = organizacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
