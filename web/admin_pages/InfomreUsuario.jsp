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
    <div style="width: 60%; margin: auto; text-align: center;">
        <h2>Gráfico de Ventas Mensuales</h2>

        <!-- Selector de Meses -->
        <label for="monthSelect">Selecciona un Mes:</label>
        <select id="monthSelect" onchange="updateChart()">
            <option value="all">Todos los Meses</option>
            <option value="0">Enero</option>
            <option value="1">Febrero</option>
            <option value="2">Marzo</option>
            <option value="3">Abril</option>
            <option value="4">Mayo</option>
            <option value="5">Junio</option>
            <option value="6">Julio</option>
            <option value="7">Agosto</option>
            <option value="8">Septiembre</option>
            <option value="9">Octubre</option>
            <option value="10">Noviembre</option>
            <option value="11">Diciembre</option>
        </select>

        <!-- Botón de impresión -->
        <button class="btn btn-primary btn-sm m-3" onclick="printChart()">Imprimir Gráfico</button>

        <!-- Canvas para la gráfica -->
        <canvas id="myChart"></canvas>
    </div>

    <script>
        //empezamos a mandar ej json del controlador
       $(document).ready(function() {
    const repeatCount = 1; // Cambia este valor para definir cuántas veces quieres repetir

    for (let j = 0; j < repeatCount; j++) {
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
                // Obtener el contexto del canvas
        var ctx = document.getElementById('myChart').getContext('2d');

        // Crear el gráfico circular
        var myChart = new Chart(ctx, {
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
                responsive: true, // Hacer el gráfico responsive
                plugins: {
                    legend: {
                        position: 'top', // Posición de la leyenda
                    },
                    tooltip: {
                        callbacks: {
                            label: function(tooltipItem) {
                                return tooltipItem.label + ': ' + tooltipItem.raw + ' units'; // Personalizar el tooltip
                            }
                        }
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
    }
});
 //fin a mandar ej json del controlador
    </script>
    
    </body>
  
</html>
