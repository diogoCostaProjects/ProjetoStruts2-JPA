<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<h2>Inser��o de �lbum</h2>
<br />
<br />
<s:form action="InserirAlbum" class="form-horizontal" style="margin-left:20px;">
	<div class="row">
		<div class="form-group col-md-4">
			 <input type="text" name="modelo.nome"
				class="form-control" placeholder="T�tulo do �lbum:"/>
		</div>
	</div>
	<div class="row">
		<div class="form-group col-md-2">
			 <input type="text" name="modelo.ano"
				class="form-control" placeholder="Ano de lan�amento:"/>
		</div>
	</div>
	<s:submit class="btn btn-primary" value="Salvar" />
</s:form>
