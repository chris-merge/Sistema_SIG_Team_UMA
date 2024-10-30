<%-- 
    Document   : Lista_Usuarios
    Created on : 27 oct 2024, 00:24:39
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
            HttpSession sesion = request.getSession();
            String usr = "";
            if(sesion.getAttribute("s") != null){
                //out.println("Bienvenido " + ses.getAttribute("s1"));
                usr = sesion.getAttribute("s").toString();
%>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
  <a class="navbar-brand" href="#">Developer JR</a>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="admin_pages/Admin.jsp">Inicio </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Infome</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="admin_pages/Admin.jsp">Regresar</a>
      </li>
    </ul>
  </div>
</nav>
        <%
           
            //
             ArrayList<Usuarios> ListaUsuarios= new ArrayList<Usuarios> ();
             ArrayList<Rol> ListaRol= new ArrayList<Rol> ();
            if(request.getAttribute("DatosUsuarios") == null &&  request.getAttribute("DatosRoles") == null )
                response.sendRedirect("../ControlUsuarioCRUD?mostrar");
                
            try{
                ListaUsuarios.addAll((Collection)request.getAttribute("DatosUsuarios"));
                ListaRol.addAll((Collection)request.getAttribute("DatosRoles"));
               
            }catch(Exception ex){
            ex.printStackTrace();
            } 
            
           
        %>
     <div class="container mt-5">
        <div class="row">
          <div class="col-md-12">
                <div class="card bg-dark text-white">
                    <div class="card-header">
                        <h5 class="card-title">Usuarios</h5>
                        <i class="bi bi-people-fill"></i>
                    </div>
                    <div class="card-body">
                        <table class="table table-dark w-100">
                            <thead>
                                <tr>
                                    <th>N°</th>
                                    <th>Nombre</th>
                                    <th>Correo</th>
                                    <th>Contraseña</th>
                                    <th>Rol</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                     <tbody>
                    <tr>
                   <% for(Usuarios U:ListaUsuarios){ %>
                    <td ><%=U.getId_Usuarios()%></td>
                    <td><%=U.getNombre()%></td>
                    <td><%=U.getEmail()%></td>
                    <td><%=U.getPasswor()%></td>
                    <td><%=U.getId_rol()%></td>
                    <td class="col-3" scope="row">
      <a href="admin_pages/ModificarUsuarios.jsp?id=<%=U.getId_Usuarios()%>" class="btn btn-success">
          <i class="fa-solid fa-pen-to-square fa-1x">Modificar</i>
      </a>
        
      <a href="javascript:Eliminar('e', '<%=U.getId_Usuarios()%>')"class="btn btn-danger">
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
    <script>
    let rolSelect = document.getElementById('rol');
    let privilegio = document.getElementById('privilegio');
    let op=document.getElementById("op");
    rolSelect.addEventListener('change',()=>{
       
       if (rolSelect.value==1) {
           privilegio.value="Aceeso total";
        }
        if(rolSelect.value==2){
            privilegio.value="Aceeso A reportes";
        }
    });
</script>
</html>
