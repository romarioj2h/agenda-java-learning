package com.romarioj2h.agenda.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.romarioj2h.agenda.dao.BaseDatosExcepcion;
import com.romarioj2h.agenda.dao.UsuarioDAO;
import com.romarioj2h.agenda.models.Usuario;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public LoginController() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginController(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@RequestMapping(value = "/loginForm")
	public String loginForm() {
		return "/login/loginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Usuario usuario, HttpSession httpSession) throws BaseDatosExcepcion {
		Usuario usuarioObj = usuarioDAO.obtenerPorUsuarioContrasena(usuario.getUsuario(), usuario.getContrasena());
		if (usuarioObj == null) {
			return "redirect:/login/loginForm";
		}
		httpSession.setAttribute("usuarioLogueado", usuarioObj);
		return "redirect:/index";
	}
}
