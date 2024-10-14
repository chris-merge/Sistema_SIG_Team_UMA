
<%-- 
    Document   : Login
    Created on : 29 sept 2024, 22:35:22
    Author     : chris
--%>
<%@page import="java.util.*" import="Modelo.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Css/Login.css" rel="stylesheet" type="text/css"/>
        <link href="Css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <body>
 
         <div class="container">
        <h1>Ingreso sistema SIG</h1>
        
        <form  action="UsuariosControl" method="post">
 <div class="input-group flex-nowrap mb-3">
  <span class="input-group-text" id="addon-wrapping">Nombre </span>
  <input type="text" name="txt_name" id="txt_name" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping" required>
</div>
           <!--  -->
  <div class="input-group flex-nowrap mb-3">
  <span class="input-group-text " id="addon-wrapping">Contraseña</span>
  <input type="password" class="form-control " id="password" placeholder="Username" aria-label="Passwprd" name="txt_passord" aria-describedby="addon-wrapping"required>
</div>
           <div class="mb-3">
               <button type="submit" name="validar" value="validar" id="validar" name="validar" onclick="Validacion()">LOGIN</button>
           </div>
           
        </form>
    </div> 
          <%
            HttpSession sesion = request.getSession();
            if(request.getAttribute("r") != null){
                if(request.getAttribute("r").equals("1")){
                    sesion.setAttribute("usr", request.getAttribute("txt_user"));
                    response.sendRedirect("html/Home.jsp");
                    //response.sendRedirect(request.getContextPath() + "/html/Home.jsp");

                }
                else{
                out.println("<script>Swal.fire('Error Credenciales Incorrectas');</script>");
         }
            }
        %>
    </body>
   
</html>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<<script>
    function Validacion()
    {
       let inputName=document.getElementById("txt_name").value.trim();
       let inputpassword=document.getElementById("password").value.trim();
       if (inputName ===" " && inputpassword ===" ") {
       Swal.fire({
  icon: "error",
  title: "Oops...",
  text: "Campos vacios!",
  footer: '<¿?</a>'
});
       
}
    }
</script>