package com.romarioj2h.agenda.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession httpSession = request.getSession();
		
		if (
			request.getRequestURI().endsWith("login/loginForm") ||
			request.getRequestURI().endsWith("login/login") ||			
			request.getRequestURI().contains("/resources")
		) {
			return true;
		}
		
		if (httpSession.getAttribute("usuarioLogueado") == null) {
			response.sendRedirect("/agenda/login/loginForm");
			return false;			
		}
		return true;
	}
}
