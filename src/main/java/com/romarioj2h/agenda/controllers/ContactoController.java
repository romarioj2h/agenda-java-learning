package com.romarioj2h.agenda.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.romarioj2h.agenda.dao.ContactoDAO;
import com.romarioj2h.agenda.models.Contacto;
import com.romarioj2h.agenda.dao.BaseDatosExcepcion;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

	@Autowired
	private ContactoDAO contactoDAO;

	public ContactoController() {
		// TODO Auto-generated constructor stub
	}
	
	public ContactoController(ContactoDAO contactoDAO) {
		this.contactoDAO = contactoDAO;
	}

	@RequestMapping(value = "/agregar", method = RequestMethod.POST)
	public ModelAndView guardar(
		@Valid Contacto contacto, 
		BindingResult bindingResult
	) throws BaseDatosExcepcion {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("/contacto/nuevo");
		}
		contactoDAO.agregar(contacto);
		return new ModelAndView("redirect:contacto/"+contacto.getId());
	}
	
	@RequestMapping("/nuevo")
	public String nuevo() {
		return "/contacto/nuevo";
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() throws BaseDatosExcepcion {
		ModelAndView modelAndView = new ModelAndView("/contacto/listado");
		List<Contacto> contactos = contactoDAO.listado();
		modelAndView.addObject("contactos", contactos);
		return modelAndView;
	}
	
	@RequestMapping("/borrar")
	public String borrar(Contacto contacto) throws BaseDatosExcepcion {
		contactoDAO.borrar(contacto);
		
		return "redirect:listado";
	}
	
	@RequestMapping("/contacto/{id}")
	public ModelAndView contacto(
		@PathVariable("id") Integer id
	) throws BaseDatosExcepcion {
		Contacto contacto = contactoDAO.obtener(id);
		ModelAndView modelAndView = new ModelAndView("/contacto/contacto");
		modelAndView.addObject("contacto", contacto);
		return modelAndView;
	}
}
