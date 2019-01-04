package com.romarioj2h.agenda.dao;

import com.romarioj2h.agenda.models.Usuario;

public interface UsuarioDAO {
	
	public Usuario obtener(Integer id);

	public Usuario obtenerPorUsuarioContrasena(String usuario, String contrasena);
}
