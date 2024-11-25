<%-- 
    Document   : Contactos
    Created on : 23 nov 2024, 02:24:03
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../Css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
          <div class="container">
        <h1 class="text-center mt-5">Contáctanos</h1>
        <form action="submit-form.php" method="post" class="mt-4">
            <div class="form-group">
                <label for="name">Nombre:</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="email">Correo electrónico:</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="message">Mensaje:</label>
                <textarea class="form-control" id="message" name="message" rows="4" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>

        <h2 class="mt-5">Contáctanos a través de:</h2>
        <div class="mt-3">
            <a href="mailto:tuemail@gmail.com" class="btn btn-outline-danger">Gmail</a>
            <a href="https://www.facebook.com/tu_pagina" class="btn btn-outline-primary">Facebook</a>
            <a href="https://www.instagram.com/tu_perfil" class="btn btn-outline-danger">Instagram</a>
            <a href="https://wa.me/tu_numero" class="btn btn-outline-success">WhatsApp</a>
        </div>
    </div>
    </body>
</html>
