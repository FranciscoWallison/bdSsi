<%@ include file="/cabecalho.jsp"%>

<%
	String userName = null;
	String sessionID = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("usuario"))
				userName = cookie.getValue();
		}
	}
%>

<div class="container">
	<h1 style="text-align: center; background: rgb(40, 96, 144); color: rgb(255, 255, 255)">Relat�rios
		da Secretaria de Seguran�a de Itapipoca</h1>
	<table class="table table-stripped table-hover table-bordered">
		<form action="relatorioDistrito" method="POST">
			<tr>
				<th>Relat�rio de informa��es gerais de Distritos</th>
				<th><input class="btn btn-primary" style="float: right"
					type="submit" value="Gera Relat�rio" /></th>
			</tr>
		</form>
		<form action="relatorioDelito" method="POST">
			<tr>
				<th>Relat�rio de informa��es sobre Delitos Internos</th>
				<th><input class="btn btn-primary" style="float: right"
					type="submit" value="Gera Relat�rio" /></th>
			</tr>
		</form>
	
	<form action="LogoutServlet" method="post">
		<th></th>
		<th><input class="btn btn-primary" style="float: right" type="submit"
			value="Logout" /></th>
	</form>
</table>

<%@ include file="/rodape.jsp"%>