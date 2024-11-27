<%-- 
    Document   : Empleados_dasboard
    Created on : 17 nov 2024, 15:01:41
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
         <!-- Carga de los arrays --> 
        <%
             ArrayList<Empleados> ListaEmpleados= new ArrayList<Empleados> ();
            if(request.getAttribute("DatosEmpleados") == null )
                response.sendRedirect("../ControlEmpleados?mostrar");
                
            try{
                ListaEmpleados.addAll((Collection)request.getAttribute("DatosEmpleados"));
               
               
            }catch(Exception ex){
            ex.printStackTrace();
            } 
        %>
       <div class="container-fluid">
        <div class="row">
        <!--Navegador-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
  <a class="navbar-brand" href="#">Developer JR</a>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
       <li class="nav-item">
                       <a class="nav-link activebtn btn-primary" href="admin_pages/Admin.jsp">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link  " href="pages_Empleados/Empleados.jsp">Regresar</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link"  href="Empleados/GraficoEmpleado.jsp">Reportes</a>
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
<!-- Tabla de carga de datos-->
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
                                    <th>Apellido</th>
                                    <th>Cargo</th>
                                    <th>Telefono</th>
                                    <th>Direccion</th>
                                    <th>Usuario</th>
                                </tr>
                            </thead>
                            <tbody>
                    <tr>
                   <% for(Empleados E:ListaEmpleados){ %>
                   <td><%=E.getId_persona()%></td>
                    <td><%=E.getNombre()%></td>
                    <td><%=E.getApellido()%></td>
                    <td><%=E.getId_cargo()%></td>
                    <td><%=E.getTelefono()%></td>
                    <td><%=E.getDireccion()%></td>
                    <td><%=E.getId_user()%></td>
                    <td>
      <a href="admin_pages/ModificarEmpleado.jsp?id=<%=E.getId_persona()%>" class="btn btn-success">
          <i class="fa-solid fa-pen-to-square fa-1x">Modificar</i>
      </a>
      <a href="javascript:Eliminar('e', '<%=E.getId_persona()%>')"class="btn btn-danger">
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
    <script>
     function Eliminar(elim, id){
                var r = confirm("¿Seguro que desea eliminar el registro?");
                if(r)
                    window.location.href = "ControlEmpleados?eliminar=" + elim + "&id=" + id;
            }
</script>
</html>
