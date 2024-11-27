<%-- 
    Document   : ModificarProyectos
    Created on : 18 nov 2024, 02:20:56
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
                       <a class="nav-link activebtn btn-primary" href="Admin.jsp">Inicio</a>
                     
                        </li>
                        <li class="nav-item">
                            <a class="nav-link  " href="../html/Proyectos.jsp">Agregar Proyectos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../Pages_Proyecto/InformeProyecto.jsp">Reportes</a>
                            
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Configuraciones</a>
                        </li>
    </ul>
  </div>
</nav>
<%
    //LISTA DE EMPLEADO
    //Empleados empleados =new Empleados();
    //EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    //ACCESO A CAPA DE CARGO
    //Cargo cargo;
    //CargoDAO cargoDAO=new CargoDAO();
    //comparacion 
      //ArrayList<Empleados>FiltroIDeEmpleado=empleadoDAO.MostrarEmpleado();
      if(request.getParameter("id")!=null ){
             Proyecto proyecto = new Proyecto();
            ProyectoDAO proyectoDAO = new ProyectoDAO();
             int id = Integer.parseInt(request.getParameter("id"));
             proyecto = proyectoDAO.BuscarProyectoBuscarPorId(id);
                 Empleados empleados =new Empleados();
                EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    //ACCESO A CAPA DE CARGO
    Cargo cargo;
    CargoDAO cargoDAO=new CargoDAO();
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
                        <input type="text" name="id" value="<%=proyecto.getId_proyeto()%>" hidden="">
                    </div>
                    <div class="card-body">
                        <div class="mb-3">
                            <label for="estado" class="form-label">Estado</label>
                            <input type="text" class="form-control" id="estado" name="estado" value="<%=proyecto.getEstado()%>">
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
                            <input type="text" class="form-control" id="nombreProyecto" name="nombre" placeholder="Nombre del proyecto" value="<%=proyecto.getNombre_proyecto()%>">
                        </div>
                        <div class="mb-3">
                            <label for="fechaInicio" class="form-label">Fecha de Inicio</label>
                            <input type="date" class="form-control" id="fechaInicio" name="fechaInicio" value="<%=proyecto.getFecha_inicio()%>">
                        </div>
                        <div class="mb-3">
                            <label for="fechaFinalizacion" class="form-label">Fecha de Finalización</label>
                            <input type="date" class="form-control" id="fechaFinal" name="fechaFinal" value="<%=proyecto.getFecha_Finalizacion()%>">
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
                            <textarea class="form-control" id="Enunciado" name="Enunciado" rows="3" value="<%=proyecto.getDescripcion()%>"></textarea>
                        </div>
                    </div>
                    <%}%>
                </div>
            </div>
        </div>
        <!-- Botones de acción -->
        <div class="text-center mt-4">
            <button type="submit" class="btn btn-primary" name="modificar" id="modificar">Modificar Proyecto</button>
        </div>
    </form>
</div>
    </body>
</html>
