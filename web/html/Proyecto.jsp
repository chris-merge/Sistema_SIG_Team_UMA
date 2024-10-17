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
     <link rel="stylesheet" href="style.css">
    <script src="java.js" defer></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="../js/proyecto.js" type="text/javascript"></script>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> 
    </head>
    <style>
        
body {
    background-color: #1e1e2f;
    color: #f4f4f9;
    font-family: 'Poppins', sans-serif;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

h1, h2 {
    color: #ffffff;
    text-align: center;
}

.container {
    width: 85%;
    margin: 40px auto;
    padding: 20px;
    background-color: #2a2a3e;
    border-radius: 10px;
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);
}


.navbar {
    display: flex;
    justify-content: flex-start;
    background-color: #14141f;
    padding: 10px;
    border-radius: 5px;
    margin-bottom: 20px;
}

.navbar a {
    color: #ffffff;
    text-decoration: none;
    font-size: 20px;
    padding: 10px 20px;
    background-color: #007bff;
    border-radius: 5px;
    transition: background-color 0.3s;
}

.navbar a:hover {
    background-color: #0056b3;
}


.project-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 20px 0;
    margin-bottom: 20px;
}

.project-header h2 {
    margin: 0;
}


button {
    padding: 10px 20px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s, transform 0.3s;
}

button:hover {
    background-color: #0056b3;
    transform: translateY(-2px);
}

.add-project-btn, .status-btn, .jefe-btn, .project-name-btn {
    display: flex;
    align-items: center;
    justify-content: center;
}

button i {
    margin-right: 8px;
}

.jefe-img {
    width: 50px;
    height: 50px;
    border-radius: 50%;
    margin-right: 10px;
}


table {
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
    background-color: #2f2f44;
    border-radius: 5px;
    overflow: hidden;
}

table thead {
    background-color: #14141f;
}

table th, table td {
    padding: 15px;
    text-align: left;
    border-bottom: 1px solid #444;
}

table th {
    color: #ffffff;
    text-transform: uppercase;
    font-weight: 600;
}

table td {
    color: #dddddd;
}

table tr:hover {
    background-color: #3b3b54;
}


.modal {
    display: none;
    position: fixed;
    z-index: 1;
    padding-top: 100px;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.8);
}

.modal-content {
    background-color: #2f2f44;
    margin: auto;
    padding: 20px;
    border-radius: 10px;
    width: 40%;
    color: #ffffff;
    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.4);
}

.close-btn {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close-btn:hover, .close-btn:focus {
    color: #ffffff;
    cursor: pointer;
}

.modal h2 {
    text-align: center;
    margin-bottom: 20px;
}

.modal ul {
    list-style: none;
    padding: 0;
}

.modal ul li {
    margin: 10px 0;
}

.modal ul li button {
    background-color: #007bff;
    border: none;
    padding: 10px 15px;
    color: white;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.modal ul li button:hover {
    background-color: #0056b3;
}

#addProjectForm input, #addProjectForm select {
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    border-radius: 5px;
    border: none;
    background-color: #3b3b54;
    color: white;
}

#addProjectForm button {
    width: 100%;
    background-color: #28a745;
    margin-top: 15px;
}

#addProjectForm button:hover {
    background-color: #218838;
}

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
                <label for="projectName">Nombre del Proyecto:</label>
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