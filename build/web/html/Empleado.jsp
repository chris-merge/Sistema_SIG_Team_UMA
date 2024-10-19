<%-- 
    Document   : Empleado
    Created on : 18 oct 2024, 15:01:19
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../Css/empleados.css" rel="stylesheet" type="text/css"/>
        <link href="../Css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <!-- comment -->
   
    <div class="container" id="agregar-empleado">
        <nav class="navbar bg-body-tertiary">
        <div class="container-fluid">
        <a class="navbar-brand" href="Home.jsp">Regresar</a>
        </div>
        </nav>
     <div class="row">
   <div class="col-md-6" id="empleado">
                <h2 id="titulo">Agregar Empleado</h2>
                <form>
                    <div class="mb-3 p-3">
                        <label for="nombre" class="form-label">Nombre:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" value="Julio">
                    </div>
                     <div class="mb-3 p-3">
                        <label for="nombre" class="form-label">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" value="Julio">
                    </div>
                    <div class="mb-3 p-3">
                        <label for="cargo" class="form-label">Cargo:</label>
                        <input type="text" class="form-control" id="cargo" name="cargo" value="Desarrollador">
                    </div>
                    <div class="mb-3 p-3">
                        <label for="cargo" class="form-label">telefono</label>
                        <input type="text" class="form-control" id="cargo" name="cargo" value="Desarrollador">
                    </div>
                    <div class="mb-3 p-3">
                        <label for="cargo" class="form-label">direccion</label>
                        <input type="text" class="form-control" id="direccion" name="direccion" value="Desarrollador">
                    </div>
                    <div class="mb-3 p-3">
                        <label for="cargo" class="form-label">Usuario</label>
                        <input type="text" class="form-control" id="direccion" name="direccion" value="Desarrollador">
                    </div>
                      <div class="mb-3 p-3">
                    <button type="submit" class="btn btn-primary">Agregar</button>
                    </div>
                    <!-- comment -->
                   
                </form>
     </div >
     <!-- comment -->
         <div class="col-md-6" id="buscar" >
             <form action="action">
                  <div class="mb-3 p-3">
                        <label for="nombre" class="form-label">Nombre:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" value="Julio">
                    </div>
                 <div class="mb-3 p-3">
                        <label for="nombre" class="form-label">Telefono</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" value="Julio">
                    </div>
                  <div class="mb-3 p-3">
                        <label for="edad" class="form-label">Edad:</label>
                        <input type="number" class="form-control" id="edad" name="edad" value="20">
                    </div>
                  
                     <div class="mb-3 p-3">
                    <button type="submit" class="btn btn-primary">Buscar</button>
                    </div>
             </form>
         </div>
       <!-- comment -->

  <table class="table">
  <thead>
    <tr>
      <th scope="col">N</th>
      <th scope="col">Nombre</th>
      <th scope="col">Apellido</th>
      <th scope="col">Cargo</th>
      <th scope="col">Edad</th>
      <th scope="col">Telefono</th>
      <th scope="col">Direccion</th>
      <th scope="col">Correo</th>
       <th scope="col">Usuario</th>
       <th scope="col">Acciones</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td colspan="2">Larry the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>
    <!-- comment -->
    </div>
</div>
    </body>
</html>
