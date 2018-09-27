<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<h2>Lista de M�sicas</h2>
<div class="row">
	<a href="/TreinaWeb2Struts2Teste/Musica/Inserir"
		class="btn btn-primary" style="margin-left: 20px;">Inserir nova
		m�sica</a>
</div>
<s:if test="modelos.size() > 0">
	<table class="table table-striped">
		<thead>
			<th>Id da m�sica</th>
			<th>Nome da m�sica</th>
			<th>�lbum</th>
			<th>A��es</th>
		</thead>
		<tbody>
			<s:iterator value="modelos">
				<tr>
					<s:url action="Alterar" var="urlAtualizar">
						<s:param name="id" value="id"></s:param>
					</s:url>
					<s:url action="Excluir" var="urlExcluir">
						<s:param name="id" value="id"></s:param>
					</s:url>
					<s:url action="Detalhar" var="urlDetalhar">
						<s:param name="id" value="id"></s:param>
					</s:url>
					<td><s:property value="id"></s:property></td>
					<td><s:property value="nome"></s:property></td>
					<td><s:property value="album.nome"></s:property></td>
					<td><s:a href="%{urlAtualizar}">Atualizar</s:a> | <s:a
							href="%{urlExcluir}">Excluir</s:a> | <s:a href="%{urlDetalhar}">Detalhar</s:a>
					</td>

				</tr>
			</s:iterator>
		</tbody>
	</table>
</s:if>
<s:else>
	<i>N�o existem m�sicas cadastradas ...</i>
</s:else>




