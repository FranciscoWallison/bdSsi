<%@ include file="/cabecalho.jsp"%>

<title>Insert title here</title>


<div class="container">
	<table class="table table-stripped table-hover table-bordered">
		<form action="relatorioDistrito" method="POST">
		<tr>
			<th>Relatório de informações gerais de Distritos</th>
			<th><input class="btn btn-primary" style="float : right" type="submit"
				value="Gera Relatório" /></th>
		</tr>
		</form>
		<form action="relatorioDelito" method="POST">
		<tr>
			<th>Relatório de informações sobre Delitos Internos</th>
			<th><input class="btn btn-primary" style="float : right" type="submit"
				value="Gera Relatório" /></th>
		</tr>
		</form>
	</table>
	<%@ include file="/rodape.jsp"%>