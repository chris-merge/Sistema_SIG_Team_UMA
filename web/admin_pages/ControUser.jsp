<%-- 
    Document   : ControUser
    Created on : 25 oct 2024, 23:51:20
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
         <nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
  <a class="navbar-brand" href="#">Developer JR</a>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
     
      <li class="nav-item">
        <a class="nav-link" href="InfomreUsuario.jsp">Infome</a>
        
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Admin.jsp">Regresar</a>
      </li>
      
    </ul>
  </div>
</nav>
<%
            HttpSession sesion = request.getSession();
            String usr = "";
            if(sesion.getAttribute("s") != null){
                //out.println("Bienvenido " + ses.getAttribute("s1"));
                usr = sesion.getAttribute("s").toString();
%>
       <div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="card">
                <img src="../Img/Usuario/agregar (2).png" alt=""/>
                <div class="card-body ">
                    <h5 class="card-title text-center">Agregar Usuarios</h5>
                    <div class="row justify-content-center">
                     <a href="AgregarUsuario.jsp" class="btn btn-primary ">Ir a agregar</a>
                     
                     </div>
 
                </div>
            </div>
        </div>
        
        <div class="col-md-4">
            <div class="card">
                <img src="../Img/Usuario/lista.png" alt=""/>
                <div class="card-body">
                    <h5 class="card-title text-center">Lista de usuario</h5>
                     <div class="row justify-content-center">
                     <a href="Lista_Usuarios.jsp" class="btn btn-primary ">Ir a lista</a>
                     </div>
                   
                </div>
            </div>
        </div>
        
        <div class="col-md-4">
            <div class="card">
               
                <img src="../Img/Usuario/reporte.png" alt=""/>
                <div class="card-body">
                    <h5 class="card-title text-center">Gerar Reporte </h5>
                       <div class="row justify-content-center">
                     <a href="InfomreUsuario.jsp" class="btn btn-primary ">Generar Reporte</a>
                     </div>
                   
                </div>
            </div>
        </div>
    </div>
</div>
<%
    }
            else{
                response.sendRedirect("Login.jsp");
            }
            if(request.getParameter("c") != null){
                sesion.removeAttribute("s");
                sesion.invalidate();
                response.sendRedirect("../Login.jsp");
            }
            //
            
            //
            if (request.getParameter("action") != null && request.getParameter("action").equals("logout")) {
        sesion.invalidate(); // Invalida la sesión
        response.sendRedirect("../index.html"); // Redirige a la página de inicio de sesión
    }
%>
    </body>
    
</html>
