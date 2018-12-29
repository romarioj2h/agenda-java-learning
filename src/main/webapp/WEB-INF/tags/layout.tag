<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.rawgit.com/yegor256/tacit/gh-pages/tacit-css-1.3.5.min.css" />
</head>
<body>
	<div>
		<a href="/agenda/index">Home</a> |
		Contacto: <a href="/agenda/contacto/nuevo">Nuevo</a> | 
		<a href="/agenda/contacto/listado">Listado</a>
	</div>
	<div id="body">
		<jsp:doBody />
	</div>
</body>
</html>