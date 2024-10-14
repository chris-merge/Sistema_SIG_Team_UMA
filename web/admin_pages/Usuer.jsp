<%-- 
    Document   : Usuer
    Created on : 12 oct 2024, 14:42:24
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
        <div class="container mt-5">
        <h1 class="text-center mb-4">Libros</h1>
        <form>
            <div class="form-group">
                <label for="titulo">Título</label>
                <input type="text" class="form-control" id="titulo" placeholder="Ingrese el título del libro">
            </div>
            <div class="form-group">
                <label for="año">Año de Publicación</label>
                <input type="number" class="form-control" id="año" placeholder="Ingrese el año de publicación">
            </div>
            <div class="form-group">
                <label for="autor">Autor</label>
                <input type="text" class="form-control" id="autor" placeholder="Ingrese el nombre del autor">
            </div>
            <div class="form-group">
                <label for="editorial">Editorial</label>
                <input type="text" class="form-control" id="editorial" placeholder="Ingrese la editorial">
            </div>
            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-primary mr-2">Nuevo</button>
                <button type="submit" class="btn btn-primary mr-2">Guardar</button>
                <button type="submit" class="btn btn-primary mr-2">Modificar</button>
                <button type="submit" class="btn btn-primary">Cancelar</button>
            </div>
        </form>
    </div>
    </body>
</html>
