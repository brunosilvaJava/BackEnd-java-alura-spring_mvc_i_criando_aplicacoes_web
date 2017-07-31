<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <input type="text" name="titulo" />
    </div>
    
    <div>
        <label>Descrição</label>
        <textarea rows="10" cols="20" name="descricao"></textarea>
    </div>
    
    <div>
        <label>Páginas</label>
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