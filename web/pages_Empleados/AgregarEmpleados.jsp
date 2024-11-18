<%-- 
    Document   : AgregarEmpleados
    Created on : 16 nov 2024, 01:57:40
    Author     : chris
--%>

<%@page import="java.util.*" import="Modelo.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../Css/AddEmpleado.css" rel="stylesheet" type="text/css"/>
        <link href="../Css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
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
            
              Rol rol = new Rol();
            RolDAO rolDAO=new RolDAO();
             ArrayList<Rol> ListaRol= rolDAO.MostrarRol();
             //lista de cargos
             Cargo cargo = new Cargo();
             CargoDAO cargoDAO = new CargoDAO();
             ArrayList<Cargo> ListaCargo= cargoDAO.MostrarCargo();
        %>
    <body>
        <!--Navegador-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
  <a class="navbar-brand" href="#">Developer JR</a>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link btn btn-primary" href="Admin.jsp">Inicio </a>
      </li>
      <li class="nav-item ">
        <a class="nav-link btn btn-primary " href="#">Infome</a>
      </li>
      <li class="nav-item">
        <button type="button" class="nav-link btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
           Agregar Cargo
        </button>
      </li>
      <li class="nav-item">
         <a class="nav-link btn btn-primary" href="../admin_pages/Empleados_dasboard.jsp">Dashboard Empleado</a>
      </li>
      <li class="nav-item">
        <a class="nav-link btn btn-primary" href="ControUser.jsp">Regresar</a>
      </li>
    </ul>
     
  </div>
</nav>

       <div class="container">
    <div class="card-form">
        <h2>Agregar Empleado</h2>
        <form action="../ControlEmpleados" method="post">
            <div class="row">
               
                <!-- Primera columna -->
                <div class="col-md-6">
                    <!-- Campo de nombre -->
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingrese su nombre"/>
                    </div>

                    <!-- Campo de apellido -->
                    <div class="mb-3">
                        <label for="apellido" class="form-label">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Ingrese su apellido">
                    </div>

                    <!-- Campo de teléfono -->
                    <div class="mb-3">
                        <label for="telefono" class="form-label">Teléfono</label>
                        <input type="tel" class="form-control" id="telefono" name="telefono" placeholder="Ingrese su teléfono">
                    </div>

                    <!-- Campo de dirección -->
                    <div class="mb-3">
                        <label for="direccion" class="form-label">Dirección</label>
                        <input type="text" class="form-control" id="direccion" name="direccion"  placeholder="Ingrese su dirección">
                    </div>
                </div>

                <!-- Segunda columna -->
                <div class="col-md-6">
                    <!-- Campo de Usuario -->
                    <div class="mb-3">
                        <label for="nombreUsuario" class="form-label">Nombre de Usuario</label>
                        <input type="text" class="form-control" id="iniciales" name="user" readonly>
                    </div>

                    <div class="mb-3">
                        <label for="correoElectronico" class="form-label">Correo Electrónico</label>
                        <input type="email" class="form-control" id="correoElectronico" name="email" placeholder="name@example.com">
                    </div>

                    <div class="mb-3">
                        <label for="contrasena" class="form-label">Contraseña</label>
                        <input type="password" class="form-control" id="password" name="password">
                    </div>

                    <!-- Campo de cargo -->
                    <div class="mb-3">
                                 <label for="acceso" class="form-label">Cargo</label>
                                 <select class="form-select" id="cargo" name="cargo" >
                                      <option value="">Seleccione un rol</option>
                                        <% for(Cargo C:ListaCargo){ %>
                                        <option value="<%=C.getId_cargo()%>" id="op" name="cargo">
                                            <%=C.getNombre_cargo()%>
                                        </option>
                                   <% }%> 
                                 </select>
                  </div>
                    <!-- rol -->
                    <div class="mb-3">
                                 <label for="acceso" class="form-label">ROl</label>
                                 <select class="form-select" id="rol" name="rol" >
                                      <option value="">Seleccione un rol</option>
                                        <% for(Rol R:ListaRol){ %>
                                        <option value="<%=R.getId_Permiso()%>" id="op" name="rol">
                                            <%=R.getNombre_rol()%>
                                        </option>
                                   <% }%> 
                                 </select>
                  </div>
                </div>
            </div>

            <!-- Botón para agregar usuario -->
            <div class="text-center">
               
                 <button type="submit" class="btn btn-success" name="guardar" id="guardar" >Guardar Empleado</button>
            </div>
        </form>
    </div>
</div>
  <!-- Modal -->
  <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Agregar Cargo</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="../ControlCargo" method="post">
                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="nombreCargo" name="nombreCargo" required>
                        </div>
                        
                        <button type="submit" class="btn btn-success" name="guardar" id="guardar" >Enviar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Modal -->
   <script>
    // Obtener los elementos de los inputs de Nombre, Apellido e Iniciales
    const inputNombre = document.getElementById("nombre");
    const inputApellido = document.getElementById("apellido");
    const inputIniciales = document.getElementById("iniciales");

    // Función que se ejecuta cada vez que el usuario escribe en los inputs de nombre o apellido
    function actualizarIniciales() {
        // Obtener las iniciales del nombre y apellido
        const nombre = inputNombre.value.trim();
        const apellido = inputApellido.value.trim();

        // Si los campos de nombre y apellido no están vacíos, obtener las iniciales
        let iniciales = "";
        if (nombre) {
            iniciales += nombre.charAt(0).toUpperCase(); // Primera letra del nombre
        }
        if (apellido) {
            iniciales += apellido.charAt(0).toUpperCase(); // Primera letra del apellido
        }
 // Obtener el año actual
        const year = new Date().getFullYear();

        // Concatenar las iniciales con el año
        iniciales += year;
        // Asignar las iniciales al campo "Iniciales"
        inputIniciales.value = iniciales;
    }

    // Agregar eventos para actualizar las iniciales cada vez que se escriba en los campos
    inputNombre.addEventListener("input", actualizarIniciales);
    inputApellido.addEventListener("input", actualizarIniciales);
</script>

    </body>
 
</html>
