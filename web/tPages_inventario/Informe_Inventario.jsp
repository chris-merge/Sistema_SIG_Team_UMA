<%-- 
    Document   : Informe_Inventario
    Created on : 27 nov 2024, 10:29:36
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
       <li class="nav-item">
                       <a class="nav-link activebtn btn-primary" href="#">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link  " href="html/Proyectos.jsp">Agregar Proyectos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Pages_Proyecto/InformeProyecto.jsp">Informe</a>
                           
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Configuraciones</a>
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
            
            Cargo cargo = new Cargo();
            CargoDAO cargoDAO=new CargoDAO();
             ArrayList<Cargo> ListaCargo= cargoDAO.MostrarCargo();
        %>
   
        <h2>Gráfico de Usuarios</h2>

        <!-- Selector de Meses -->
        <label for="monthSelect">Selecciona un Mes:</label>
        <select id="monthSelect" onchange="updateChart()">
            <option value="all">Todos los Meses</option>
            <%for(Cargo c:ListaCargo){ %>
            <option value="<%=c.getId_cargo()%>" id="id_rol" name="rol"><%=c.getNombre_cargo()%></option>
            <%}%>
        </select>

        <!-- Botón de impresión -->
        <button class="btn btn-primary btn-sm m-3" onclick="printChart()">Imprimir Gráfico</button>
        <!-- comment -->
         <div class="container">
        <div   
 class="row justify-content-center">
            <div class="col-md-8">   

            <!-- Canvas para la gráfica -->
        <canvas id="myBarChart"></canvas>
            </div>
        </div>
    </div>
    <script>
        //empezamos a mandar ej json del controlador
       $(document).ready(function() {
        // Intervalo de 3 segundos (3000 milisegundos)
    //setInterval(obtenerDatos, 12000);
    // Variable para guardar la instancia de la gráfica
    //let myChart;
   // function obtenerDatos() {
        $.ajax({
            url: "../tControlChartjs?inventario", // Reemplaza con la URL real de tu Servlet
            type: "GET",
            dataType: "json",
            success: function(data) {
                //Empezar a llamas las listas
                let ListaInventario=data.ListaInventario;
               
                //let Listatotal = data.Listatotal;
               // console.log("Usuarios:", ListaUser);
                //console.log("rol", ListaRoles);
                 console.log("ListaInventario", ListaInventario);
                
                //console.log(data); // Log para depuración

                // Mostrar los datos en la página
                var html = "<ul>";
                for (var i = 0; i < data.length; i++) {
                    html += "<li>" + data[i] + "</li>";
                }
                html += "</ul>";
                $("#result").html(html);
                
                //accedere a la lista para cambiar a los labels
                let labelsproyecto = ListaProyecto.map(proyecto=>proyecto.fecha_inicio);
                // acceder a la cantidad de usuarios 
               let Countproyecto = ListaCount.map(item => item.id_proyeto);
               // console.log("total2", userCounts);
                 // Verificar si la gráfica ya existe, y en tal caso, destruirla antes de crear una nueva
              //  if (myChart) {
             //       myChart.destroy();
             //   }
        // Crear el gráfico circular
       const ctx = document.getElementById('myBarChart').getContext('2d');
    const inventoryPieChart = new Chart(ctx, {
        type: 'pie', // Usa 'doughnut' para un gráfico de dona
        data: {
            labels: ['Producto 1', 'Producto 2', 'Producto 3'], // Nombres de los productos
            datasets: [{
                label: 'Proporción de Inventario',
                data: [50, 30, 70], // Cantidades
                backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56'],
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: {
                    position: 'top',
                }
            }
        }
    });

                
               //termina el codigo de charJS
               
               //codigo de imprimir 
            },
            error: function(xhr, status, error) {
                console.error("Error al obtener los datos:", error);
            }
        });
        //fin del intervalo de 3s
   // }
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
