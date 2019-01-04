package com.romarioj2h.agenda.dao;

import java.util.List;

import com.romarioj2h.agenda.models.Contacto;

public interface ContactoDAO {

	public boolean agregar(Contacto contacto);
	public List<Contacto> listado();
	public boolean borrar(Contacto contacto);
	public Contacto obtener(Integer id);
}
