<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Incluir Produto</title>
</head>
<body>

	<form:form action="${s:mvcUrl('PC#gravarProduto').build()}" commandName="produto" enctype="multipart/form-data">

		<div>
			<label>Título</label> 
			<form:input path="titulo" />
			<form:errors path="titulo" />
		</div>

		<div>
			<label>Descrição</label>
		 	<form:textarea rows="10" cols="10" path="descricao" />
			<form:errors path="descricao" />
		</div>

		<div>
			<label>Páginas</label> 
			<form:input path="paginas" />
			<form:errors path="paginas" />
		</div>

		<div>
			<label>Data de Lançamento</label> 
			<form:input path="dataLancamento" />
			<form:errors path="dataLancamento" />
		</div>

		<c:forEach items="${tipos}" var="TipoLivro" varStatus="status">
			<div>
				<label>${TipoLivro}</label> 
				<form:input path="precos[${status.index}].valor" /> 
				<form:input path="precos[${status.index}].tipo" value="${TipoLivro}" />
			</div>
		</c:forEach>
		
		<div>
		    <label>Sumário</label>
		    <input name="sumario" type="file" />
		</div>

		<button type="submit">Cadastrar</button>

	</form:form>

</body>
</html>