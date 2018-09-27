<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<h2>Inserção de música</h2>
<br />
<br />

<s:form action="InserirMusica" class="form-horizontal" style="margin-left:20px;">
<div class="row">
	<div class="form-group col-md-4">
		<input type="text" name="modelo.nome" class="form-control"
			placeholder="Título da música:" />
	</div>
</div>
<div class="row">
	<div class="form-group col-md-2">
		<s:select class="form-control" label="Álbum" headerKey="-1" headerValue="Selecione um álbum"
		list="albuns" name="albumId" listKey="id" listValue="nome" />
	</div>
</div>
<s:submit class="btn btn-primary" value="Salvar" />
</s:form>