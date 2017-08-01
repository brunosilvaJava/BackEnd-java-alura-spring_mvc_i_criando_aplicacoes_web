<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Incluir Produto</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/produtos/gravarProduto" method="post">
    
    <div>
        <label>Título</label>
        <form:errors path="produto.titulo" />
        <input type="text" name="titulo" />
    </div>
    
    <div>
        <label>Descrição</label>
        <form:errors path="produto.descricao" />
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    
    <div>
        <label>Páginas</label>
         <form:errors path="produto.paginas" /> 
        <input type="text" name="paginas" />
    </div>
    
    <c:forEach items="${tipos}" var="TipoLivro" varStatus="status">
        <div>
            <label>${TipoLivro}</label>
            <input type="text" name="precos[${status.index}].valor" />
            <input type="hidden" name="precos[${status.index}].tipo" value="${TipoLivro}" />
        </div>
    </c:forEach>
    
    <button type="submit">Cadastrar</button>
    
</form>

</body>
</html>