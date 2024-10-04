<%-- 
    Document   : Login
    Created on : 29 sept 2024, 22:35:22
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Css/Login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
      <div class="login-container">
          <form accion="ControlUsuarios" method="post">
    <!-- comment -->
<div class="mb-3">
<label for="exampleFormControlInput1" class="form-label">Usuario</label>
<input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Nombre de Usuario">
</div>
    <!-- comment -->
<div class="mb-3">
<label for="exampleFormControlInput1" class="form-label">Contraseña </label>
<input type="password" class="form-control" id="exampleFormControlInput1" placeholder="password">
</div>
<!-- comment -->
<div class="mb-3">
<button type="submit">Iniciar</button>
</div>
 </form>
</div>
    </body>
</html>
