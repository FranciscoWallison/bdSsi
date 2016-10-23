<%@ include file="/includes.jsp"%>
<c:import url="cabecalho.jsp" />
${msgUsuario}
<form action="sistema?logica=AutenticaUsuario&nome=Parametro"
	method="post" id="formLogar">
	Login: <input type="text" name="login" value="" /> Senha: <input
		type="password" name="senha" value="" /> <input type="submit"
		value="Logar" />
</form>

<c:import url="rodape.jsp" />
