<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<h2>Alteração de álbum</h2>
<h4 class="alert alert-info"><s:label name="modelo.nome"></s:label> </h4>
<br />
<br />
<s:form action="AlterarAlbum" class="form-horizontal" style="margin-left:20px;">
	<s:hidden name="modelo.id" />
	<div class="row">
		<div class="form-group col-md-4">
			<input type="text" name="modelo.nome" class="form-control"
				placeholder="Novo título:" />
		</div>
	</div>
	<div class="row">
		<div class="form-group col-md-2">
			<input type="text" name="modelo.ano" class="form-control"
				placeholder="Nova data de lançamento:" />
		</div>
	</div>
	<s:submit class="btn btn-primary" value="Salvar" />
</s:form>
