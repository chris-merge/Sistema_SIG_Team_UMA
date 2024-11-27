<%-- 
    Document   : InfomreUsuario
    Created on : 30 oct 2024, 23:16:12
    Author     : chris
--%>

<%@page import="java.util.*" import="Modelo.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <link href="../Css/bootstrap.css" rel="stylesheet" type="text/css"/>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </head>

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
   
        <h2>Gráfico de Usuarios</h2>

        <!-- Selector de Meses -->
        <label for="monthSelect">Selecciona un Mes:</label>
        <select id="monthSelect" onchange="updateChart()">
            <option value="all">Todos los Meses</option>
            <%for(Rol r:ListaRol){ %>
            <option value="<%=r.getId_rol()%>" id="id_rol" name="rol"><%=r.getNombre_rol()%></option>
            <%}%>
        </select>

        <!-- Botón de impresión -->
        <button class="btn btn-primary btn-sm m-3" onclick="printChart()">Imprimir Gráfico</button>
        <!-- comment -->
         <div class="container">
        <div   
 class="row justify-content-center">
            <div class="col-md-5">   

            <!-- Canvas para la gráfica -->
        <canvas id="myChart"></canvas>
            </div>
        </div>
    </div>

       


    <script>
        //empezamos a mandar ej json del controlador
       $(document).ready(function() {
        // Intervalo de 3 segundos (3000 milisegundos)
   // setInterval(obtenerDatos, 6000);
    // Variable para guardar la instancia de la gráfica
    //let myChart;
    //function obtenerDatos() {
        $.ajax({
            url: "../ControlChart_JS?userChart", // Reemplaza con la URL real de tu Servlet
            type: "GET",
            dataType: "json",
            success: function(data) {
                //Empezar a llamas las listas
                let ListaUser=data.ListaUser;
                let ListaRoles=data.ListaRoles;
                let Listatotal = data.Listatotal;
                console.log("Usuarios:", ListaUser);
                console.log("rol", ListaRoles);
                 console.log("total", Listatotal);
                //console.log(data); // Log para depuración

                // Mostrar los datos en la página
                var html = "<ul>";
                for (var i = 0; i < data.length; i++) {
                    html += "<li>" + data[i] + "</li>";
                }
                html += "</ul>";
                $("#result").html(html);
                
                //accedere a la lista para cambiar a los labels
                let labelsRoles = ListaRoles.map(rol=>rol.nombre_rol);
                // acceder a la cantidad de usuarios 
                let userCounts = Listatotal.map(item => item.id_Usuarios);
                console.log("total2", userCounts);
                 // Verificar si la gráfica ya existe, y en tal caso, destruirla antes de crear una nueva
               // if (myChart) {
                 //   myChart.destroy();
                //}
                // Obtener el contexto del canvas
               
        var ctx = document.getElementById('myChart').getContext('2d');

        // Crear el gráfico circular
         myChart = new Chart(ctx, {
            type: 'pie',  // Tipo de gráfico (en este caso, circular)
            data: {
                labels:labelsRoles,  // Etiquetas de las porciones
                datasets: [{
                    label: 'Roles',
                    data: userCounts,  // Datos correspondientes a cada porción
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)', // Color de la porción "Red"
                        'rgba(54, 162, 235, 0.2)', // Color de la porción "Blue"
                        'rgba(255, 205, 86, 0.2)'  // Color de la porción "Yellow"
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)', // Color del borde de la porción "Red"
                        'rgba(54, 162, 235, 1)', // Color del borde de la porción "Blue"
                        'rgba(255, 205, 86, 1)'  // Color del borde de la porción "Yellow"
                    ],
                    borderWidth: 1
                }]
            },
           options: {
                            responsive: true,
                            animation: {
                                duration: 1000, // Suaviza la transición
                                easing: 'easeInOutQuart' // Tipo de suavizado
                            },
                            plugins: {
                                legend: {
                                    position: 'top'
                                },
                                tooltip: {
                                    callbacks: {
                                        label: function(tooltipItem) {
                                            return tooltipItem.label + ': ' + tooltipItem.raw + ' units';
                                        }
                                    }
                                }
                            }
                        }
                //
                  
            }
    );
                
               //termina el codigo de charJS
               
               //codigo de imprimir 
            },
            error: function(xhr, status, error) {
                console.error("Error al obtener los datos:", error);
            }
        });
        //fin del intervalo de 3s
    //}
});
 //fin a mandar ej json del controlador
 
                    // Función para imprimir la gráfica centrada y con el título "Estadísticas"
                    function printChart() {
                        // Obtener el elemento canvas y convertirlo en una imagen
                        const canvas = document.getElementById('myChart');
                        const dataUrl = canvas.toDataURL();

                        // Crear una ventana temporal para imprimir
                        const printWindow = window.open('', '_blank');
                        printWindow.document.write(`
            <html>
                <head>
                    <title>Imprimir Gráfico</title>
                    <style>
                        body { display: flex; align-items: center; justify-content: center; height: 100vh; margin: 0; }
                        .container { text-align: center; }
                        h2 { margin-bottom: 20px; }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <h2>Estadísticas</h2>
                        <img src="${dataUrl}" alt="Gráfico de Ventas Mensuales"/>
                    </div>
                </body>
            </html>
        `);
                        printWindow.document.close();

                        // Esperar a que la imagen cargue y luego activar el cuadro de diálogo de impresión
                        printWindow.onload = function() {
                            printWindow.print();
                        };
                    }
                    //  fin del boton de imprimir
 //funcion de onclick 
 /*function Select(){
     let id=document.getElementById("id_rol").value;
      window.location.href"../ControlChart_JS?userChart"
 }*/
    </script>
    
    </body>
  
</html>
