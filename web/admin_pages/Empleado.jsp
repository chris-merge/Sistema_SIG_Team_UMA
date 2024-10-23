<%-- 
    Document   : Empleado
    Created on : 23 oct 2024, 00:51:12
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
        <!-- comment -->
        <div class="container mt-5">
        <div class="row align-items-center">
            <div class="col-auto">
                <a href="#" class="text-decoration-none">
                    <i class="bi bi-house-door"></i>
                </a>
            </div>
            <div class="col">
                <h2>Nómina de Empleados</h2>
                <img src="icono-nomina.png" alt="Ícono de nómina">
            </div>
        </div>

        <div class="row mt-4">
            <div class="col-md-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" value="Julia">
            </div>
            <div class="col-md-3">
                <label for="cargo" class="form-label">Cargo</label>
                <input type="text" class="form-control" id="cargo" value="Desarrollador">
            </div>
            <div class="col-md-3">
                <label for="edad" class="form-label">Edad</label>
                <input type="number" class="form-control" id="edad" value="20">
            </div>
            <div class="col-md-3">
                <img src="icono-calculadora.png" alt="Ícono de calculadora" class="float-end">
            </div>
        </div>
    </div>

        <!-- comment -->
        <!-- Lista de Proyectos -->
   <div class="container mt-5">
        <div class="row">
          <!-- comment -->
            <div class="col-md-12">
                <div class="card bg-dark text-white">
                    <div class="card-header">
                        <h5 class="card-title">Usuarios</h5>
                        <i class="bi bi-people-fill"></i>
                    </div>
                    <div class="card-body">
                        <table class="table table-dark">
                            <thead>
                                <tr>
                                    <th>N°</th>
                                    <th>Nombre</th>
                                    <th>Contraseña</th>
                                    <th>Rol</th>
                                    <th>Privilegios</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                    <tr>
              
                    <td>
      <a href="VistaModificar.jsp?id>" class="btn btn-success">
          <i class="fa-solid fa-pen-to-square fa-1x">Generar Grafico</i>
      </a>
      <a href="" class="btn btn-danger">
          <i class="fa-solid fa-trash fa-1x">Exportar</i>
      </a>
                    </td>
                    </tr>
                 
                 </tbody>
               </table>
                    </div>
                </div>
            </div>
<!-- comment -->
      </div>
  </div>
    </body>
</html>
