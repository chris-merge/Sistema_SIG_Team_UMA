<%-- 
    Document   : Dashboar_Proyecto
    Created on : 17 nov 2024, 22:07:04
    Author     : chris
--%>

<%@page import="java.util.*" import="Modelo.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link href="Css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
             ArrayList<Proyecto> Listaproyecto= new ArrayList<Proyecto> ();
            if(request.getAttribute("DatosProyectos") == null ){
                response.sendRedirect("../ControlProyectos?mostrar");
            }
            try{
                Listaproyecto.addAll((Collection)request.getAttribute("DatosProyectos"));
               
               
            }catch(Exception ex){
            ex.printStackTrace();
            } 
        %>
 
        <!-- cONTENDIDO -->       
<div class="container-fluid">
        <div class="row">
        <!--Navegador-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
  <a class="navbar-brand" href="#">Developer JR</a>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
       <li class="nav-item">
                       <a class="nav-link activebtn btn-primary" href="#">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link  " href="html/Proyectos.jsp">Agregar Proyectos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Pages_Proyecto/InformeProyecto.jsp">Informe</a>
                           
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Configuraciones</a>
                        </li>
    </ul>
  </div>
</nav>
 <br>
        <!-- Control De dashboard -->
 <div class="col-md-9 ml-sm-auto col-lg-10 px-4">
                <h2>Dashboard</h2>
                <div class="row">
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Total Empleados</h5>
                                <p class="card-text">50</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Empleados Activos</h5>
                                <p class="card-text">45</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Empleados Inactivos</h5>
                                <p class="card-text">5</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
            <br>
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
        <!-- bUSQUEDA -->           
<!-- Tabla de carga de datos-->
            <div class="col-md-12">
                <div class="card bg-dark text-white">
                    <div class="card-header">
                        <h5 class="card-title">Proyectos</h5>
                        <i class="bi bi-people-fill"></i>
                    </div>
                    <div class="card-body">
                        <table class="table table-dark">
                            <thead>
                                <tr>
                                    <th>N°</th>
                                    <th>Nombre de Proyecto</th>
                                    <th>Jefe acargo</th>
                                    <th>Descripcion</th>
                                    <th>Estado</th>
                                    <th>Fecha de Inicio</th>
                                    <th>Fecha de Finalizacion</th>
                                </tr>
                            </thead>
                            <tbody>
                    <tr>
                   <% for(Proyecto p:Listaproyecto){ %>
                   <td><%=p.getNombre_proyecto()%></td>
                   <td><%=p.getJefe()%></td>
                   <td><%=p.getDescripcion()%></td>
                   <td><%=p.getEstado()%></td>
                    <td><%=p.getFecha_inicio()%></td>
                     <td><%=p.getFecha_Finalizacion()%></td>
                    <td>
      <a href="admin_pages/ModificarProyectos.jsp?id=<%=p.getId_proyeto()%>" class="btn btn-success">
          <i class="fa-solid fa-pen-to-square fa-1x">Modificar</i>
          
      </a>
      <a href="javascript:Eliminar('e', '<%=p.getId_proyeto()%>')"class="btn btn-danger">
          <i class="fa-solid fa-trash fa-1x">Eliminar</i>
      </a>
                    </td>
                    </tr>
                    <% } %>
                 </tbody>
                 
               </table>
                    </div>
                </div>
            </div>
    </body>
</html>
