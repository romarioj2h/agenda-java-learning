package com.romarioj2h.agenda.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.romarioj2h.agenda.models.Usuario;
 
@Controller
public class IndexController {
	String mensaje = "Welcome to Spring MVC!";
 
	@RequestMapping("/index")
	public ModelAndView showMessage(HttpSession httpSession) {
		System.out.println("en el controller");
 
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("mensaje", mensaje);
		Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogueado");
		mv.addObject("nombre", usuario.getUsuario());
		return mv;
	}
}
