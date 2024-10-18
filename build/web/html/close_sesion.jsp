<%-- 
    Document   : close_sesion
    Created on : 18 oct 2024, 00:41:38
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>    
<%
  if (request.getParameter("c") != null) {
    session.removeAttribute("usr"); // Elimina el atributo de sesión
    session.invalidate(); // Invalida la sesión
    response.sendRedirect("../Login.jsp");
  }
%>
<h1>title</h1>
    </body>
</html>
