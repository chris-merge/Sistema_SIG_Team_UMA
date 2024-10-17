/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function abrirExploradorArchivos() {
    const input = document.createElement('input');
    input.type = 'file';
    input.click();
}


function mostrarVentanaEstado() {
    document.getElementById('estadoModal').style.display = 'block';
}


function cerrarVentanaEstado() {
    document.getElementById('estadoModal').style.display = 'none';
}


function seleccionarEstado(estado) {
    alert('Estado seleccionado: ' + estado);
    cerrarVentanaEstado();
}


function mostrarJefesProyecto() {
    const jefes = ["Jefe 1", "Jefe 2", "Jefe 3"];
    alert("Jefes de Proyecto:\n" + jefes.join("\n"));
}

