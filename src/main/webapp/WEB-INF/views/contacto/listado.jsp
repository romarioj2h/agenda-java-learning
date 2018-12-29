<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<t:layout>
	<h2>Listado de contactos</h2>
	<table>
		<thead>
			<th>ID</th>
			<th>Nombre</th>
			<th>Telefono</th>
			<th>Acciones</th>
		</thead>
		<tbody>
			<c:forEach items="${contactos}" var="contacto">
				<tr>
					<td>${contacto.id}</td>
					<td>${contacto.nombre}</td>
					<td>${contacto.telefono}</td>
					<td>
						<a href="/agenda/contacto/borrar?id=${contacto.id}">Borrar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table> 
</t:layout>