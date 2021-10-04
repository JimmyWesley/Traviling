<%@page import="model.Hotel"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %> 
  
<jsp:useBean id="Lista" type="model.Retorno[]" scope="request" />

<!DOCTYPE html>
<html lang="pt-br">
  <head>
  
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
   
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css"
      integrity="sha256-mmgLkCYLUQbXn0B1SRqzHar6dCnv9oZFPEC1g1cwlkk="
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
      crossorigin="anonymous"
    />
    <title>Traveller</title>
  </head>
<body>
 <h1> Hotel encontrado com sucesso! </h1>
 <hr> 
 
 <div>
 <section class="container">
      <div class="justify-content-center align-items-center row h-100">      
       
 <c:forEach var="li" items="${Lista}">
  
   <div class="col-10 col-lg-4">
          <div class="loginservlet ">
            <div class="text-left mb-2 text-white bg-info px-4" >
              <div class="hotel-id"><c:out value="${li.dest_type}" /></div>
              <div class="hotel-nome"><c:out value="${li.name}"/></div>
              <div class="hotel-site"><c:out value="${li.label}"/></div>
              <div class="hotel-img"><img alt="" src="<c:out value="${li.image_url}"/>"></div>
              <a href=""><button class="btn btn-block btn-lg text-white bg-warning " name="enviardados"></a>
                Reservar
              </button>
            </div>
          </div>
   </div>         
</c:forEach>
      </div>
    </section>
 </div>
 
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
      crossorigin="anonymous"
    ></script>
  </body>
</html>