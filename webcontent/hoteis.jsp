<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>     
<jsp:useBean id="Hotel" scope="request" type="model.Hotel"></jsp:useBean>
<html>
<head>
<meta charset="UTF-8">
<title>.: Sucesso :.</title>
</head>
<body>
 <h1> Usuario encontrado com sucesso! </h1>
 <hr> 
      ID: <c:out value="${Hotel.id}"/> <br>
      Nome: <c:out value="${Hotel.nome}"/> <br>
      Email: <c:out value="${Hotel.descricao}"/> <br> 
</body>
</html>