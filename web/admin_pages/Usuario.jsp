<%-- 
    Document   : Usuario
    Created on : 19 oct 2024, 23:58:25
    Author     : chris
--%>

<%@page import="java.util.*" import="Modelo.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="../Css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../Css/usuarios.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
       
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            String usr = "";
            if(sesion.getAttribute("s") != null){
                //out.println("Bienvenido " + ses.getAttribute("s1"));
                usr = sesion.getAttribute("s").toString();
            }
            else{
                response.sendRedirect("../Login.jsp");
            }
            if(request.getParameter("c") != null){
                sesion.removeAttribute("s");
                sesion.invalidate();
                response.sendRedirect("../Login.jsp");
            }
            //
             ArrayList<Usuarios> ListaUsuarios= new ArrayList<Usuarios> ();
            if(request.getAttribute("DatosUsuarios") == null)
                response.sendRedirect("../ControlUsuarioCRUD?mostrar");
            try{
                ListaUsuarios.addAll((Collection)request.getAttribute("DatosUsuarios"));
            }catch(Exception ex){
            }
            
            //
            if (request.getParameter("action") != null && request.getParameter("action").equals("logout")) {
        sesion.invalidate(); // Invalida la sesión
        response.sendRedirect("../index.html"); // Redirige a la página de inicio de sesión
    }
        %>
        <!-- comment -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
  <a class="navbar-brand" href="#">Developer JR</a>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Inicio </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Infome</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Admin.jsp">Regresar</a>
      </li>
    </ul>
  </div>
</nav>
        <!-- comment -->
     
        <!-- comment -->
 <div class="container mt-5">
        <div class="row">
            <div class="col-md-6">
                <div class="card bg-dark text-white">
                    <div class="card-header">
                        <h5 class="card-title">Agregar Usuario</h5>
                        <i class="bi bi-person-plus-fill"></i>
                    </div>
                    <div class="card-body">
                        <form>
                            <div class="mb-3">
                                <label for="nombre" class="form-label">Nombre de Usuario:</label>
                                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingrese el nombre de usuario">
                            </div>
                            <div class="mb-3">
                                <label for="acceso" class="form-label">Contraseña</label>
                                <input type="text" class="form-control" id="acceso" name="acceso" placeholder="Ingrese el nivel de acceso">
                            </div>
                            <div class="mb-3">
                                <label for="acceso" class="form-label">Rol:</label>
                                <input type="text" class="form-control" id="acceso" name="acceso" placeholder="Ingrese el nivel de acceso">
                            </div>
                            <div class="mb-3">
                                <label for="acceso" class="form-label">Privilegio:</label>
                                <input type="text" class="form-control" id="acceso" name="acceso" placeholder="Ingrese el nivel de acceso">
                            </div>
                            <div class="mb-3">
                                <label for="acceso" class="form-label">Acceso:</label>
                                <input type="text" class="form-control" id="acceso" name="acceso" placeholder="Ingrese el nivel de acceso">
                            </div>
                            <!-- comment -->
                            <button type="submit" class="btn btn-primary">Agregar</button>
                             <button type="submit" class="btn btn-secondary">Modificar</button>
                              <button type="submit" class="btn btn-danger">Elliminar</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
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
                                    <th>Acceso</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <!-- comment -->
    </body>
</html>
