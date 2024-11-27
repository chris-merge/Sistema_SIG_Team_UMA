<%-- 
    Document   : Nomina
    Created on : 27 nov 2024, 15:52:02
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <link href="../Css/bootstrap.css" rel="stylesheet" type="text/css"/>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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
                            <a class="nav-link  " href="../admin_pages/Admin.jsp">Regresar</a>
                           
                        </li>
    </ul>
  </div>
</nav>
    <div style="width: 70%; margin: auto;">
        <canvas id="nominaChart"></canvas>
    </div>
    <script>
        // Datos de la nómina
        const empleados = ["Juan", "Ana", "Pedro", "Sofía", "Carlos"];
        const salarios = [2500, 3000, 2800, 3200, 2900];

        // Configuración del gráfico
        const config = {
            type: 'bar', // Tipo de gráfico
            data: {
                labels: empleados, // Nombres de los empleados
                datasets: [{
                    label: 'Salario (USD)', // Etiqueta del conjunto de datos
                    data: salarios, // Valores de los salarios
                    backgroundColor: [
                        'rgba(75, 192, 192, 0.2)', // Colores de las barras
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 99, 132, 0.2)'
                    ],
                    borderColor: [
                        'rgba(75, 192, 192, 1)', // Colores de los bordes
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 99, 132, 1)'
                    ],
                    borderWidth: 1 // Grosor de los bordes
                }]
            },
            options: {
                responsive: true, // Ajuste al tamaño del contenedor
                plugins: {
                    legend: {
                        display: true, // Mostrar la leyenda
                        position: 'top',
                    },
                    tooltip: {
                        enabled: true // Activar tooltip
                    }
                },
                scales: {
                    y: {
                        beginAtZero: true // Eje Y comienza en 0
                    }
                }
            }
        };

        // Renderizar el gráfico
        const ctx = document.getElementById('nominaChart').getContext('2d');
        new Chart(ctx, config);
    </script>
</body>
</html>