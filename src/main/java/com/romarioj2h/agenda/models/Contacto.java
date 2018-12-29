package com.romarioj2h.agenda.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Contacto {
	private Integer id;
	
	@NotNull
	@Size(min=5, message="{contacto.formulario.nombre.tamano}")
	private String nombre;
	
	private String telefono;
	
	public Contacto() {
		
	}
	
	public Contacto(Integer id, String nombre, String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
