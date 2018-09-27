
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<h2>Detalhes do álbum</h2>
<br />
<br />

<div class="row">
	<div class="form-group col-md-4">
		Título do álbum: <s:label name="modelo.nome"></s:label>
	</div>
</div>
<div class="row">
	<div class="form-group col-md-2">
		Ano de lançamento: <s:label name="modelo.ano"></s:label>
	</div>
</div>
<br />
<a href="/TreinaWeb2Struts2Teste/Album/ListarAlbuns" class="btn btn-primary"> Voltar a lista
	de álbuns</a>

