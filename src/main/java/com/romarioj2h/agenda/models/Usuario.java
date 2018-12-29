package com.romarioj2h.agenda.models;

public class Usuario {
	private Integer id;
	
	private String usuario;
	
	private String contrasena;
	
	public Usuario() {
		
	}
	
	public Usuario(Integer id, String usuario, String contrasena) {
		this.id = id;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}
