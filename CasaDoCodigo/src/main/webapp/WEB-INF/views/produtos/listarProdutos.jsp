<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Produto</title>
</head>
<body>

	<h1>Lista de Produtos</h1>
	
    <p> ${statusInclusaoLivro}</p>
    
    <table>
        <tr>
            <td>Título</td>
            <td>Descrição</td>
            <td>Páginas</td>
        </tr>
        <c:forEach items="${produtos}" var="produto">
	        <tr>
	            <td><a href="${s:mvcUrl('PC#detalharProduto').arg(0,produto.idProduto).build()}">${produto.titulo}</a></td>
	            <td>${produto.descricao}</td>
	            <td>${produto.paginas}</td>
	        </tr>
    	</c:forEach>
    </table>
        
</body>
</html>