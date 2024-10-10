
<%-- 
    Document   : Login
    Created on : 29 sept 2024, 22:35:22
    Author     : chris
--%>
<%@page import="java.util.*" import="Modelo.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Css/Login.css" rel="stylesheet" type="text/css"/>
        <link href="Css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         <div class="container">
        <h1>Ingreso sistema SIG</h1>
        <form  action="UsuariosControl" metod="post">
 <div class="input-group flex-nowrap mb-3">
  <span class="input-group-text" id="addon-wrapping">Nombre </span>
  <input type="text" name="s" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
</div>
           <!--  -->
  <div class="input-group flex-nowrap mb-3">
  <span class="input-group-text " id="addon-wrapping">Contraseña</span>
  <input type="password" class="form-control " placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
</div>
           <div class="mb-3">
               <button type="submit" name="validar" value="validar" id="validar" name="validar">LOGIN</button>
           </div>
           
        </form>
    </div>
    </body>
</html>
