<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<h2>Detalhes da m�sica</h2>
<br />
<br />


<div class="row">
	<div class="form-group col-md-4">
		Id da m�sica:
		<s:label name="modelo.id"></s:label>
	</div>
</div>
<div class="row">
	<div class="form-group col-md-4">
		T�tulo da m�sica:<s:label name="modelo.nome"></s:label>
	</div>
</div>
<div class="row">
	<div class="form-group col-md-2">
		�lbum:
		<s:label name="modelo.album.nome"></s:label>
	</div>
</div>
<br />
<a href="/TreinaWeb2Struts2Teste/Musica/ListarMusicas" class ="btn btn-primary"> Voltar a lista de m�sicas</a>