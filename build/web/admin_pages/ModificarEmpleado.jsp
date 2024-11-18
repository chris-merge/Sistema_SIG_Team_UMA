<%-- 
    Document   : ModificarEmpleado
    Created on : 17 nov 2024, 15:40:59
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
    <body>
     <%
              /* Rol rol = new Rol();
            RolDAO rolDAO=new RolDAO();
             ArrayList<Rol> ListaRol= rolDAO.MostrarRol();
             //lista de cargos
             Cargo cargo = new Cargo();
             CargoDAO cargoDAO = new CargoDAO();
             ArrayList<Cargo> ListaCargo= cargoDAO.MostrarCargo();
             */
             //Acceso a Usuariso
              //usuario
         Usuarios usuarios;
         UsuaruirsDAO usuaruirsDAO = new UsuaruirsDAO();
           
            if(request.getParameter("id")!=null){
             Empleados empleado = new Empleados();
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
             int id = Integer.parseInt(request.getParameter("id"));
             empleado = empleadoDAO.BuscarEmpleadoBuscarPorId(id);
            //FILTRO DE BUSQUEDA DE USUARIOS
            int SechUser=empleado.getId_user();
             ArrayList<Usuarios> FiltroID= new  ArrayList<Usuarios>();
             usuarios=usuaruirsDAO.BuscarUsuarioBuscarPorId(SechUser);
             if (usuarios!=null) {
                     FiltroID.add(usuarios);
                 } else{}
           // ArrayList<Usuarios>Lista=usuaruirsDAO.BuscarUsuarioBuscarPorId(SechUser);
             Usuarios considencia= null;
               for (Usuarios U:FiltroID) {
                   
                       considencia=U;
                   
               }
               //lista de usuarios
               int IdUser=considencia.getId_Usuarios();
               String NombreUsuario=considencia.getNombre();
               String Correo=considencia.getEmail();
               //lista de rol
              Rol rol = new Rol();
            RolDAO rolDAO=new RolDAO();
             ArrayList<Rol> ListaRol= rolDAO.MostrarRol();
             //lista de cargos
             Cargo cargo = new Cargo();
             CargoDAO cargoDAO = new CargoDAO();
             ArrayList<Cargo> ListaCargo= cargoDAO.MostrarCargo();
         %>   
       <div class="container">
    <div class="card-form">
        <h2>Agregar Empleado</h2>
        <form action="../ControlEmpleados" method="post">
            <div class="row">
               
                <!-- Primera columna -->
                <div class="col-md-6">
                    <div class="mb-3">
                        <label for="nombre" class="form-label">ID</label>
                        <input type="text" class="form-control" id="nombre" name="idEmpleado" placeholder="Ingrese su nombre" value="<%=empleado.getId_persona()%>"/>
                    </div>

                    <!-- Campo de nombre -->
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ingrese su nombre" value="<%=empleado.getNombre()%>"/>
                    </div>

                    <!-- Campo de apellido -->
                    <div class="mb-3">
                        <label for="apellido" class="form-label">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" placeholder="Ingrese su apellido" value="<%=empleado.getApellido()%>">
                    </div>

                    <!-- Campo de teléfono -->
                    <div class="mb-3">
                        <label for="telefono" class="form-label">Teléfono</label>
                        <input type="tel" class="form-control" id="telefono" name="telefono" placeholder="Ingrese su teléfono" value="<%=empleado.getTelefono()%>">
                    </div>

                    <!-- Campo de dirección -->
                    <div class="mb-3">
                        <label for="direccion" class="form-label">Dirección</label>
                        <input type="text" class="form-control" id="direccion" name="direccion"  placeholder="Ingrese su dirección"value="<%=empleado.getDireccion()%>">
                    </div>
                </div>

                <!-- Segunda columna -->
                <div class="col-md-6">
                    <div class="mb-3">
                        <label for="nombreUsuario" class="form-label">ID </label>
                        <input type="text" class="form-control" id="iniciales" name="id_user" value="<%=considencia.getId_Usuarios()%>" hidden="true">
                    </div>
                    <!-- Campo de Usuario -->
                    <div class="mb-3">
                        <label for="nombreUsuario" class="form-label">Nombre de Usuario</label>
                        <input type="text" class="form-control" id="iniciales" name="user" value="<%=considencia.getNombre()%>">
                    </div>

                    <div class="mb-3">
                        <label for="correoElectronico" class="form-label">Correo Electrónico</label>
                        <input type="email" class="form-control" id="correoElectronico" name="email" placeholder="name@example.com" value="<%=considencia.getEmail()%>">
                    </div>

                    <div class="mb-3">
                        <label for="contrasena" class="form-label">Contraseña</label>
                        <input type="password" class="form-control" id="password" name="password" value="<%=considencia.getPasswor()%>">
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
               
                 <button type="submit" class="btn btn-success" name="modificar" id="guardar" >Guardar Empleado</button>
            </div>
        </form>
    </div>
</div>
<%
     }
 %>
    </body>
 
</html>
