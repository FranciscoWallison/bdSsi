<%@ include file="/cabecalho.jsp"%>

<title>Insert title here</title>


<div class="container">
	<table class="table table-stripped table-hover table-bordered">
		<form action="relatorioDistrito" method="POST">
		<tr>
			<th>Relat�rio de informa��es gerais de Distritos</th>
			<th><input class="btn btn-primary" style="float : right" type="submit"
				value="Gera Relat�rio" /></th>
		</tr>
		</form>
		<form action="relatorioDelito" method="POST">
		<tr>
			<th>Relat�rio de informa��es sobre Delitos Internos</th>
			<th><input class="btn btn-primary" style="float : right" type="submit"
				value="Gera Relat�rio" /></th>
		</tr>
		</form>
	</table>
	<%@ include file="/rodape.jsp"%>