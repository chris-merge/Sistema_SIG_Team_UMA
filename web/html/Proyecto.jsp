<%-- 
    Document   : Proyecto
    Created on : 16 oct 2024, 22:15:29
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../Css/proyecto.css" rel="stylesheet" type="text/css"/>
    <script src="java.js" defer></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="../js/proyecto.js" type="text/javascript"></script>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> 
    </head>
    <style>
     
    </style>
<body>

    <div class="container">
        <!-- Sección de navegación con ícono de Home -->
        <nav class="navbar">
            <a href="Home.jsp" class="home-link"><i class="fas fa-home"></i> Home</a>
             
        </nav>

        <h1>Gestión de Proyectos</h1>
        <div class="project-header">
            <div class="project-info">
                <!-- Botón para el Nombre del Proyecto -->
                <button class="project-name-btn" onclick="nombreProyectoClick()"><i class="fas fa-folder"></i> Nombre del Proyecto</button>
            </div>
            <div class="project-leader">
                <!-- Botón para mostrar la lista de jefes de proyecto -->
                <button class="jefe-btn" onclick="mostrarJefesProyecto()">
                    <img src="../Img/Icon/nico.png" alt=""/>
                    <h2>Jefe del Proyecto</h2>
                </button>
            </div>
            <div class="project-status">
                <!-- Botón para mostrar el estado del proyecto -->
                <button class="status-btn" onclick="mostrarVentanaEstado()"><i class="fas fa-tasks"></i> Estado</button>
            </div>
            <!-- Botón para abrir la ventana de archivos -->
            <button class="add-project-btn" onclick="abrirExploradorArchivos()">
                <i class="fas fa-folder-plus"></i> Agregar Proyecto
            </button>
        </div>

        <table>
            <thead>
                <tr>
                    <th>N°</th>
                    <th>Nombre del Proyecto</th>
                    <th>Administrador del Proyecto</th>
                    <th>Fecha de Inicio</th>
                    <th>Fecha de Finalización</th>
                    <th>Costos Objetivo</th>
                    <th>Métrica</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody id="project-list">
                <!-- Aquí se añadirán los proyectos dinámicamente -->
            </tbody>
        </table>
    </div>

    <!-- Modal para agregar un proyecto -->
    <div id="addProjectModal" class="modal">
        <div class="modal-content">
            <span class="close-btn" onclick="closeAddProjectModal()">&times;</span>
            <h2>Agregar Nuevo Proyecto</h2>
            <form id="addProjectForm">
                <label for="projectName">Nombre del ProycloseAddProjectModalecto:</label>
                <input type="text" id="projectName" required>
                <label for="projectAdmin">Administrador del Proyecto:</label>
                <input type="text" id="projectAdmin" required>
                <label for="startDate">Fecha de Inicio:</label>
                <input type="date" id="startDate" required>
                <label for="endDate">Fecha de Finalización:</label>
                <input type="date" id="endDate" required>
                <label for="costs">Costos Objetivo:</label>
                <input type="number" id="costs" required>
                <label for="metrics">Métrica:</label>
                <input type="text" id="metrics" required>
                <label for="status">Estado:</label>
                <select id="status" required>
                    <option value="Activo">Activo</option>
                    <option value="Inactivo">Inactivo</option>
                    <option value="En proceso">En proceso</option>
                    <option value="Finalizado">Finalizado</option>
                </select>
                <button type="submit">Agregar Proyecto</button>
            </form>
        </div>
    </div>

    <!-- Modal para seleccionar el estado del proyecto -->
    <div id="estadoModal" class="modal">
        <div class="modal-content">
            <span class="close-btn" onclick="cerrarVentanaEstado()">&times;</span>
            <h2>Estado del Proyecto</h2>
            <ul>
                <li><button onclick="seleccionarEstado('Activo')">Activo</button></li>
                <li><button onclick="seleccionarEstado('Inactivo')">Inactivo</button></li>
                <li><button onclick="seleccionarEstado('En proceso')">En proceso</button></li>
                <li><button onclick="seleccionarEstado('Finalizado')">Finalizado</button></li>
            </ul>
        </div>
    </div>

</body>
</html>