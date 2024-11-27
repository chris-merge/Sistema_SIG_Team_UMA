<%-- 
    Document   : AgregarUsuario
    Created on : 30 oct 2024, 21:06:34
    Author     : chris
--%>

<%@page import="java.util.*" import="Modelo.*" import="Controlador.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../Css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <style>
        label ,h2{
            color: white;
        }
        .form{
            border-radius: 25px;
        }
        #btn_registrar{
            display: flex;
            justify-content: center;
        }
        #titulo{
            display: flex;
            justify-content: center;
        }
    </style>
    <body>
<!--Navegador-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
  <a class="navbar-brand" href="#">Developer JR</a>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="Admin.jsp">Inicio </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="InfomreUsuario.jsp">Infome</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="ControUser.jsp">Regresar</a>
      </li>
    </ul>
     
  </div>
</nav>
 <%
             // ArrayList<Usuarios> ListaUsuarios= new ArrayList<Usuarios> ();
             /*
              Usuarios usuarios = new Usuarios();
            UsuaruirsDAO usuaruirsDAO = new UsuaruirsDAO();
             int id = Integer.parseInt(request.getParameter("id"));
             usuarios = usuaruirsDAO.BuscarUsuarioBuscarPorId(id);
             */
            
            Rol rol = new Rol();
            RolDAO rolDAO=new RolDAO();
             ArrayList<Rol> ListaRol= rolDAO.MostrarRol();
        %>
       <!--Navegador-->
       <!-- FORM -->
        <div class="container mt-5 ">
        <div   class="row justify-content-center">
           
            <div class="col-md-4 col-h-auto bg-dark form">
                <form action="../ControlUsuarioCRUD"  method="post">
                 <div class="mb-3" id="titulo">
                        <h2>Agregar Usuarios</h2> 
                    </div>
                    
                                 <div class="mb-3">

                        <label for="nombreUsuario" class="form-label">Nombre de Usuario</label>
                        <input type="text" class="form-control" id="nombreUsuario" name="nombre" placeholder="Ingrese su nombre de usuario">
                    </div>
                    <div class="mb-3">
                        <label for="correoElectronico" class="form-label">Correo Electrónico</label>
                        <input type="email" class="form-control"   id="correoElectronico" name="email" placeholder="name@example.com">
                    </div>
                    <div   class="mb-3">
                        <label for="contrasena" class="form-label">Contraseña</label>
                        <input type="password" class="form-control" id="password" name="password">

                    </div>
                    <div class="mb-3">
                        <label   for="rol" class="form-label">Rol</label>
                        <select class="form-select" id="rol" name="rol">
                           <%for(Rol r:ListaRol){ %>
                            <option value="<%=r.getId_rol()%>" id="id_rol" name="rol"><%=r.getNombre_rol()%></option>
                           <%}%>
                        </select>
                    </div>
                    <div class="mb-5 " id="btn_registrar">
                           <!--boton al 100-->
                <input type="submit" value="Agregar" id="Guardar" name="guardar" class="btn btn-primary" />
                
                    </div>
              
                </form>   
            </div>
        </div>
    </div>
    </body>
</html>
