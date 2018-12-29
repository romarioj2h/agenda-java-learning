<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<t:layout>
	Contacto ${contacto.getId()}: ${contacto.getNombre()} ${contacto.getTelefono()} 
</t:layout>