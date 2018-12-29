<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<t:layout>
	<h2>Nuevo contacto</h2>
	<form action="/agenda/contacto/agregar" method="post">
		Nombre: <input name="nombre" type="text" /><form:errors path="contacto.nombre"/><br/>
		Telefono: <input name="telefono" type="text" /><br/>
		<button type="submit">Enviar</button>		
	</form> 
</t:layout>