<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Login</h2>
	<form action="/agenda/login/login" method="post">
		Usuario: <input name="usuario" type="text" /><br/>
		Contraseña: <input name="contrasena" type="password" /><br/>
		<button type="submit">Enviar</button>		
	</form>
</body>
</html>