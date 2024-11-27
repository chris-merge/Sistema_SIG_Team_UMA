<%-- 
    Document   : Proyectos
    Created on : 22 oct 2024, 22:10:05
    Author     : chris
--%>

<%@page import="java.util.*" import="Modelo.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../Css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
       <!--Navegador-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
  <a class="navbar-brand" href="#">Developer JR</a>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
       <li class="nav-item">
                       <a class="nav-link activebtn btn-primary" href="#">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link  " href="../Pages_Proyecto/Dashboar_Proyecto.jsp">Regresar</a>
                        </li>
                        
                       
    </ul>
  </div>
</nav>
<%
    //LISTA DE EMPLEADO
    Empleados empleados =new Empleados();
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    //ACCESO A CAPA DE CARGO
    Cargo cargo;
    CargoDAO cargoDAO=new CargoDAO();
    //comparacion 
      ArrayList<Empleados>FiltroIDeEmpleado=empleadoDAO.MostrarEmpleado();
 %>
  <!-- comment -->
  <div class="container mt-5 dark">
    <form action="../ControlProyectos" method="post">
        <div class="row">
            <!-- Columna 1: Información del proyecto -->
            <div class="col-md-6">
                <div class="card bg-dark text-white">
                    <div class="card-header">
                        <h5 class="card-title">Información del Proyecto</h5>
                    </div>
                    <div class="card-body">
                        <div class="mb-3">
                            <label for="estado" class="form-label">Estado</label>
                            <input type="text" class="form-control" id="estado" name="estado" placeholder="Ingrese el estado del proyecto">
                        </div>
                       <!-- comment -->
                         <div class="mb-3">
                                 <label for="acceso" class="form-label">Jefe de cargo</label>
                              <select class="form-select" id="jefe" name="jefe" >
                                      <option value="">Seleccione Jefe</option>
                                        <% for(Empleados  E: FiltroIDeEmpleado){ %>
                                        <%if (E.getId_cargo()==1) { 
                                        %>
                                <option value="<%=E.getId_persona()%>" id="op" name="jefe">
                                  <%=E.getNombre()%>
                                </option>
                                <% }%>
                                <!-- llave de For -->
                                   <% }%> 
                            </select>
                  </div>
                       <!-- comment -->
                        <div class="mb-3">
                            <label for="nombreProyecto" class="form-label">Nombre del Proyecto</label>
                            <input type="text" class="form-control" id="nombreProyecto" name="nombre" placeholder="Nombre del proyecto">
                        </div>
                        <div class="mb-3">
                            <label for="fechaInicio" class="form-label">Fecha de Inicio</label>
                            <input type="date" class="form-control" id="fechaInicio" name="fechaInicio">
                        </div>
                        <div class="mb-3">
                            <label for="fechaFinalizacion" class="form-label">Fecha de Finalización</label>
                            <input type="date" class="form-control" id="fechaFinal" name="fechaFinal">
                        </div>
                    </div>
                </div>
            </div>
            <!-- Columna 2: Descripción del proyecto -->
            <div class="col-md-6">
                <div class="card bg-dark text-white">
                    <div class="card-header">
                        <h5 class="card-title">Descripción del Proyecto</h5>
                    </div>
                    <div class="card-body">
                        <div class="mb-3">
                            <label for="enunciado" class="form-label">Enunciado del Proyecto</label>
                            <textarea class="form-control" id="Enunciado" name="Enunciado" rows="3" placeholder="Escriba el enunciado del proyecto"></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="objetivo" class="form-label">Objetivo del Proyecto</label>
                            <textarea class="form-control" id="Objetivo" name="Objetivo" rows="3" placeholder="Escriba el objetivo del proyecto"></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="resultadosEsperados" class="form-label">Resultados Esperados</label>
                            <textarea class="form-control" id="Resultados" name="Resultados" rows="3" placeholder="Escriba los resultados esperados"></textarea>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Botones de acción -->
        <div class="text-center mt-4">
            <button type="submit" class="btn btn-primary" name="guardar" id="guardar">Agregar Proyecto</button>
        </div>
    </form>
</div>

  <!-- comment -->
  
    </body>
</html>
