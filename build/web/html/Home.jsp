<%-- 
    Document   : Home
    Created on : 9 oct 2024, 14:18:08
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../Css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../Css/menu_cliente.css" rel="stylesheet" type="text/css"/>
        
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
            if (request.getParameter("action") != null && request.getParameter("action").equals("logout")) {
        sesion.invalidate(); // Invalida la sesión
        response.sendRedirect("../index.html"); // Redirige a la página de inicio de sesión
    }
        %>
        
    
    <div id="menu_logo">
        <!<!-- comment --> 
         <nav class="navbar navbar-dark bg-dark justify-content-end">
  <ul class="navbar-nav">
    <li class="nav-item">
     
      <a  class="nav-link" href="?action=logout" >Cerrar sesion</a>
    </li>
  </ul>
</nav>
        
        <!-- comment -->
 <div class="slider">
     
  <ul class="contenedor">
     <li class="list-group-item">
         <div class="img_list">    
         <img src="../Img/Icon/Homme.png" class="menu_icon" alt=""/>
         <span><a href="Home.jsp"  class="nav-link active" >Menu</a> </span>
         </div>
     </li>
     <li class="list-group-item">
         <div class="img_list">    
             <img src="../Img/Icon/Proyectos.png" class="menu_icon" alt=""/>
         <span><a href="Proyecto.jsp" class="nav-link active" > buscar proyectos</a> </span>
         </div>
     </li>
    <li class="list-group-item">
        <div class="img_list">    
            <img src="../Img/Icon/Empleado.png" class="menu_icon" alt=""/>
         <span><a href="Empleado.jsp"  class="nav-link active">   buscar empleados</a> </span>
         </div>
    </li>
    <li class="list-group-item">
        <div class="img_list">    
         <img src="../Img/Icon/Usuario.png" class="menu_icon" alt=""/>
         <span><a href="#"  class="nav-link active" >   buscar usuario</a> </span>
         </div>
    </li>
    <li class="list-group-item">
        <div class="img_list">    
         <img src="../Img/Icon/Nomina.png" class="menu_icon" alt=""/>
         <span><a href="#"  class="nav-link active" > nomina de empleado</a> </span>
         </div>
    </li>
    <li class="list-group-item">
        <div class="img_list">    
         <img src="../Img/Icon/home.png" class="menu_icon" alt=""/>
         <span><a href="#"  class="nav-link active" >inventario</a> </span>
         </div>
    </li>
    <li class="list-group-item">
        <div class="img_list">    
            <img src="../Img/Icon/Ventas.png" class="menu_icon" alt=""/>
         <span><a href="#"  class="nav-link active" > ventas</a> </span>
         </div>
    </li>
    <li class="list-group-item">
        <div class="img_list">    
         <img src="../Img/Icon/Usuario.png" class="menu_icon" alt=""/>
         <span><a href="#"  class="nav-link active" > Usuario</a> </span>
         </div>
    </li>
 
  </ul>
   
</div>
<!-- comment -->
    <div id="contendor_Img">
        <img class="logo_dev" src="../Img/Logo.png" alt="fallo"/>
   </div>
 </div>
    </body>
</html>
