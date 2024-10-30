<%-- 
    Document   : ModificarUsuarios
    Created on : 27 oct 2024, 21:44:04
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
<body class="gradient-custom">
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
<!-- lista de busqueda  -->
<div class="container py-5">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="form-container p-4">
        <h2 class="text-center mb-4">Formulario de modificacion de Usuarios</h2>
        <%
            
            /*
                    MarcaDAO marcaDAO = new MarcaDAO();
                    ProductoDAO prodDAO = new ProductoDAO();
                    Producto producto = new Producto();
                    ArrayList<Marca> listaMarcas = new ArrayList<Marca>();
                    listaMarcas = marcaDAO.MostrarMarcas();
                    producto = prodDAO.ObtenerProductoPorId(Integer.parseInt(request.getParameter("id")));
      
            */
            if(request.getParameter("id")!=null){
             Usuarios usuarios = new Usuarios();
            UsuaruirsDAO usuaruirsDAO = new UsuaruirsDAO();
             int id = Integer.parseInt(request.getParameter("id"));
             usuarios = usuaruirsDAO.BuscarUsuarioBuscarPorId(id);
            
         %>
        <form class="needs-validation" novalidate>
  <div class="container">
        <div   
 class="row justify-content-center">
            <div class="col-md-6">
                <form>
                    <div class="mb-3">   

                        <label for="nombre" class="form-label">Nombre de Usuario</label>
   <input type="text" class="form-control" id="nombre" placeholder="Ingrese el nombre de usuario" value="<%=usuarios.getNombre()%>">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Correo Electrónico</label>
                        <input type="email" class="form-control"   
 id="email" placeholder="name@example.com" value="<%=usuarios.getEmail()%>">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Contraseña</label>   

                        <input type="password" class="form-control" id="password" value="<%=usuarios.getPasswor()%>">
                    </div>
                    <div class="mb-3">
 <%
     int id_rol =usuarios.getId_rol();
     //lista de roles 
            RolDAO rolDAO = new RolDAO();
            Rol rol= new Rol();
            ArrayList<Rol> list=rolDAO.MostrarRol();
 %>
                  <label  for="rol" class="form-label">Rol</label>
                        <select class="form-select" id="rol">
                            <% for(Rol r:list){ %>
                            <option value="<%=r.getId_rol()%>"><%=r.getNombre_rol()%></option>
                       <% } %>
                           
                        </select>
                    </div>
                    <button type="submit" class="btn   
 btn-primary">Agregar</button>
                </form>
            </div>
        </div>
    </div>
  <!-- fin de carga de sql -->
        </form>
           
      </div>
    </div>
  </div>
</div>


<!-- lista de busqueda  -->
<%
    }
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
