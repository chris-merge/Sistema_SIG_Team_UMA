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
        %>

        <!<!-- comment --> 
         <nav class="navbar navbar-expand-lg navbar-dark bg-dark justify-content-end">
  <ul class="navbar-nav">
    <li class="nav-item">
       
      <a class="nav-link" href="admin_pages/Usuer.jsp">Cerrar sesion</a>
    </li>
  </ul>
</nav>
        
        <!-- comment -->
    
    <div id="menu_logo">
 <div class="slider">
  <ul class="contenedor">
     <li class="list-group-item">
         <div class="img_list">    
         <img src="../Img/Icon/home.png" alt=""/>
         <span><a href="#"  class="nav-link active" >Menu</a> </span>
         </div>
     </li>
     <li class="list-group-item">
         <div class="img_list">    
         <img src="../Img/Icon/home.png" alt=""/>
         <span><a href="Proyecto.jsp" class="nav-link active" > buscar proyectos</a> </span>
         </div>
     </li>
    <li class="list-group-item">
        <div class="img_list">    
         <img src="../Img/Icon/home.png" alt=""/>
         <span><a href="#"  class="nav-link active">   buscar empleados</a> </span>
         </div>
    </li>
    <li class="list-group-item">
        <div class="img_list">    
         <img src="../Img/Icon/home.png" alt=""/>
         <span><a href="#"  class="nav-link active" >   buscar usuario</a> </span>
         </div>
    </li>
    <li class="list-group-item">
        <div class="img_list">    
         <img src="../Img/Icon/home.png" alt=""/>
         <span><a href="#"  class="nav-link active" > nomina de empleado</a> </span>
         </div>
    </li>
    <li class="list-group-item">
        <div class="img_list">    
         <img src="../Img/Icon/home.png" alt=""/>
         <span><a href="#"  class="nav-link active" >inventario</a> </span>
         </div>
    </li>
    <li class="list-group-item">
        <div class="img_list">    
         <img src="../Img/Icon/home.png" alt=""/>
         <span><a href="#"  class="nav-link active" > ventas</a> </span>
         </div>
    </li>
    <li class="list-group-item">
        <div class="img_list">    
         <img src="../Img/Icon/home.png" alt=""/>
         <span><a href="#"  class="nav-link active" > Usuario</a> </span>
         </div>
    </li>
 
  </ul>
   
</div>
<!-- comment -->
    <div id="contendor_Img">
       <img src="../Img/Logo.png" alt="fallo"/>
   </div>
 </div>
    </body>
</html>
