<%-- 
    Document   : AgregarContrato
    Created on : 23 nov 2024, 02:59:02
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
         <div class="container">
        <h1 class="text-center mt-5">Contratos</h1>
        <form action="submit-contrato.php" method="post" class="mt-4">
            <div class="form-group">
                <label for="nombre_contrato">Nombre del Contrato:</label>
                <input type="text" class="form-control" id="nombre_contrato" name="nombre_contrato" required>
            </div>
            <div class="form-group">
                <label for="presupuesto">Presupuesto:</label>
                <input type="number" class="form-control" id="presupuesto" name="presupuesto" required>
            </div>
            <div class="form-group">
                <label for="estado_actual">Estado Actual:</label>
                <select class="form-control" id="estado_actual" name="estado_actual">
                    <option value="activo" selected>Activo</option>
                    <option value="inactivo">Inactivo</option>
                    <option value="suspendido">Suspendido</option>
                </select>
            </div>
            <div class="form-group">
                <label for="fecha_inicio">Fecha de Inicio:</label>
                <input type="date" class="form-control" id="fecha_inicio" name="fecha_inicio" required>
            </div>
            <div class="form-group">
                <label for="fin_creacion">Fecha de Fin de Creación:</label>
                <input type="date" class="form-control" id="fin_creacion" name="fin_creacion" required>
            </div>
            <div class="form-group">
                <label for="id_proyecto">ID del Proyecto:</label>
                <input type="number" class="form-control" id="id_proyecto" name="id_proyecto" required>
            </div>
            <button type="submit" class="btn btn-primary">Crear Contrato</button>
        </form>
    </div>
    </body>
</html>
