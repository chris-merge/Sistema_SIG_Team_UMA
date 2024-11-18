
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
   <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <script>
        // Mostrar y ocultar la contraseña
        function togglePasswordVisibility() {
            const passwordInput = document.getElementById('password');
            const toggleIcon = document.getElementById('togglePasswordIcon');

            if (passwordInput.type === 'password') {
                passwordInput.type = 'text';
                toggleIcon.classList.remove('fa-eye');
                toggleIcon.classList.add('fa-eye-slash');
            } else {
                passwordInput.type = 'password';
                toggleIcon.classList.remove('fa-eye-slash');
                toggleIcon.classList.add('fa-eye');
            }
        }

        // Validar caracteres no permitidos
        function validatePassword(input) {
            const invalidCharacters =  /[<>()\[\],?=!°{}&¨´'` "" '' /]/g;
            if (invalidCharacters.test(input.value)) {
                input.value = input.value.replace(invalidCharacters, '');
                alert('Caracteres no permitidos eliminados.');
            }
        }
    </script>
    <body>
 
 <div class="container">
 <h1>Ingreso sistema SIG</h1>
<form action="UsuariosControl" method="post">
        <div class="input-group flex-nowrap mb-3">
            <span class="input-group-text" id="addon-wrapping">Nombre</span>
            <input type="text" name="usr" id="txt_name" class="form-control" placeholder="Username" 
                   aria-label="Username" aria-describedby="addon-wrapping" required onkeyup="habilitar()">
        </div>

        <div class="input-group flex-nowrap mb-3">
            <label for="password" class="input-group-text" id="addon-wrapping">Contraseña</label>
            <input type="password" class="form-control" id="password" name="txt_passord" 
                   placeholder="Contraseña" aria-label="Password" aria-describedby="addon-wrapping" 
                   required oninput="validatePassword(this)">
            <span class="input-group-text">
                <i class="fa fa-eye" id="togglePasswordIcon" style="cursor: pointer;" onclick="togglePasswordVisibility()"></i>
            </span>
        </div>

        <div class="mb-3">
            <button type="submit" name="validar" value="validar" id="validar">Ingresar</button>
        </div>
    </form>
    </div> 
          <%--
               HttpSession sesion = request.getSession();
            if(request.getAttribute("r") != null){
                if(request.getAttribute("r").equals("1")){
                    sesion.setAttribute("s", request.getAttribute("txt_user"));
                    response.sendRedirect("Web Pages/html/Home.jsp");
                }
                else
                    out.println("<script>Swal.fire('Error Credenciales Incorrectas');</script>");
            }
        --%>
        <%
    HttpSession sesion = request.getSession();
    if (request.getAttribute("r") != null) {
        if (request.getAttribute("r").equals("1")) {
            sesion.setAttribute("s", request.getAttribute("usr"));
            // Corregir ruta relativa para acceder a home.jsp
            //validacion de admin
            // Obtener la lista de usuarios del request
    ArrayList<Usuarios> listaUsuarios = (ArrayList<Usuarios>) request.getAttribute("listaUsuarios");
 
            if(listaUsuarios!=null)
            {
                    for (Usuarios usuario : listaUsuarios) {
                            if(usuario.getId_rol()==1){
                         response.sendRedirect("admin_pages/Admin.jsp");
                          break;
                        }else{
                        response.sendRedirect("html/Home.jsp");
                         break;
                             }
            }
            }
        } else {
            out.println("<script>Swal.fire('Error Credenciales Incorrectas');</script>");
        }
    }
%>
    </body>
  
</html>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
