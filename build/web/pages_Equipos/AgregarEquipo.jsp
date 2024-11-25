<%-- 
    Document   : AgregarEquipo
    Created on : 18 nov 2024, 23:43:34
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
    <div class="container mt-5">
        <h2>Formulario de Equipo</h2>
 <%
    //LISTA DE EMPLEADO
    Empleados empleados =new Empleados();
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    //ACCESO A CAPA DE CARGO
    Cargo cargo;
    CargoDAO cargoDAO=new CargoDAO();
    //comparacion 
      ArrayList<Empleados>FiltroIDeEmpleado=empleadoDAO.MostrarEmpleado();
    //Acceso de la lista  de proyecto
    Proyecto proyecto;
    ProyectoDAO proyectoDAO = new ProyectoDAO();
    ArrayList<Proyecto>ListaProyectos =proyectoDAO.MostrarProyecto();    
 %>
        <form>
            <div class="form-group">
                <label for="nombreEquipo">Nombre de Equipo</label>
                <input type="text" class="form-control" id="nombreEquipo" name="nomnreEquipo" placeholder="Ingrese el nombre del equipo" required>
            </div>
             <div class="form-group">
                <select class="form-select" id="jefe" name="jefe" >
                <option value="">Seleccione Jefe</option>
                 <%  for(Empleados  E: FiltroIDeEmpleado){%>
                    <%if(E.getId_cargo()==1) {  %>
                 <option value="<%=E.getId_persona()%>">
                   <%=E.getNombre()%>
                 </option>
                   <% }%> 
               <% }%> 
                </select>
            
            </div>
 <div class="form-group">
    
                <select class="form-select" id="idProyecto" name="jefe" >
                <option value="">Seleccione El proyecto</option>
                 <%for (Proyecto p:ListaProyectos) {%>
                 <option value="<%=p.getId_proyeto()%>">
                   <%=p.getNombre_proyecto()%>
                 </option>
                  <% }%>
                </select>
   
</div>
<div class="form-group">
     <label>Seleccionar Empleados</label>
    <!-- Filtrp qque no aparesca el scrum master -->
    <%  for(Empleados  E: FiltroIDeEmpleado){%>
    <%if (E.getId_cargo()!=1) {%>
   
    <div class="row">
        <!-- Primera columna -->
        <div class="contenedor">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="empleado1" name="team" value="<%=E.getId_persona()%> 1">
                <label class="form-check-label" for="empleado1"><%=E.getNombre()%> <%=E.getApellido()%></label>
            </div>
        </div>
    </div>
    <%}%>
    <%}%>
    <!-- comment -->
     
</div>

 <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>
    </body>
</html>
