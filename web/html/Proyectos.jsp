<%-- 
    Document   : Proyectos
    Created on : 22 oct 2024, 22:10:05
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
        <div class="row justify-content-between align-items-center">
            <div class="col-auto">
                <a href="../admin_pages/Admin.jsp" class="btn btn-primary">
                    <i class="bi bi-folder-plus"></i> Regresar
                </a>
            </div>
            <div class="col-auto">
                <h3 class="text-end">Proyecto</h3>
                <img src="../Img/Icon/Proyectos.png" alt="Ícono de proyecto"/>
            </div>
            <div class="col-auto">
                <a href="#" class="text-decoration-none">
                    <i class="bi bi-house-door"></i>
                </a>
            </div>
        </div>

        <div class="row mt-4">
            <div class="col-md-4">
                <label for="nombreProyecto" class="form-label">Nombre Proyecto</label>
                <input type="text" class="form-control" id="nombreProyecto" value="Zinos">
            </div>
            <div class="col-md-4">
                <label for="jefeProyecto" class="form-label">Jefe Proyecto</label>
                <input type="text" class="form-control" id="jefeProyecto" value="Julio">
            </div>
            <div class="col-md-4">
                <label for="estado" class="form-label">Estado</label>
                <input type="text" class="form-control" id="estado" value="Activo">
            </div>
        </div>
    </div>
  <!-- comment -->
  <!-- comment -->
  <div class="container mt-5">
        <div class="row">
  <!-- comment -->
            <div class="col-md-6">
                <div class="card bg-dark text-white">
                    <div class="card-header">
                        <h5 class="card-title">Agregar Usuario</h5>
                        <i class="bi bi-person-plus-fill"></i>
                    </div>
                    <div class="card-body">
                        <form>
                            <div class="mb-3">
                                <label for="nombre" class="form-label">Estado</label>
                                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingrese el nombre de usuario">
                            </div>
                            <div class="mb-3">
                                <label for="acceso" class="form-label">Jefe de Proyecto</label>
                                <input type="password" class="form-control" id="acceso" name="acceso" placeholder="***">
                            </div>
                         <!---->
                            <div class="mb-3">
                                <label for="acceso" class="form-label">Nombre de Proyecto</label>
                                <input type="password" class="form-control" id="acceso" name="acceso" placeholder="***">
                            </div>
                         <!---->
                            <div class="mb-3">
                                <label for="acceso" class="form-label">Descripcion</label>
                                <input type="text" class="form-control" id="acceso" name="acceso" placeholder="Ingrese el nivel de acceso">
                            </div>
                         <!---->
                            <div class="mb-3">
                                <label for="acceso" class="form-label">Fecha De Inicio</label>
                            <input type="date" class="form-control" id="fecha" name="fecha">
                            </div>
                         <!---->
                         <div class="mb-3">
                                <label for="acceso" class="form-label">Fecha De Finalizacion</label>
                              <input type="date" class="form-control" id="fecha" name="fecha">
                            </div>
                            <!-- comment -->
                            <button type="submit" class="btn btn-primary">Agregar</button>
                             <button type="submit" class="btn btn-secondary">Modificar</button>
                              <button type="submit" class="btn btn-danger">Elliminar</button>
                        </form>
                    </div>
                </div>
            </div>
<!-- descripciondel proyecto-->
<div class="col-md-6">
                <div class="card bg-dark text-white">
                    <div class="card-header">
                        <h5 class="card-title">Agregar Descripcion proyecto</h5>
                        <i class="bi bi-person-plus-fill"></i>
                    </div>
                    <div class="card-body">
                        <form>
                            <div class="mb-3">
                                <label for="nombre" class="form-label">Enunciado del Proyecto </label>
                               <textarea class="form-control" rows="3"></textarea>
                            </div>
                            <div class="mb-3">
                                <label for="acceso" class="form-label">objetivo del Proyecto</label>
                                <textarea class="form-control" rows="3"></textarea>
                            </div>
                         <!---->
                            <div class="mb-3">
                                <label for="acceso" class="form-label">Resultados Esperados de Proyecto</label>
                                 <textarea class="form-control" rows="3"></textarea>
                            </div>
                         <br> <br>  <br>  <br>  <br>
                            <!-- comment -->
                            <button type="submit" class="btn btn-primary">Agregar</button>
                             <button type="submit" class="btn btn-secondary">Modificar</button>
                              <button type="submit" class="btn btn-danger">Elliminar</button>
                        </form>
                    </div>
                </div>
            </div>
<!-- descripcion-->
        </div>
    </div>
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
          <i class="fa-solid fa-pen-to-square fa-1x">Modificar</i>
      </a>
      <a href="" class="btn btn-danger">
          <i class="fa-solid fa-trash fa-1x">Eliminar</i>
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
