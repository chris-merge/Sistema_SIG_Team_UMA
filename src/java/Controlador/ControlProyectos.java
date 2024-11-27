/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//
import Modelo.*;
import jakarta.servlet.RequestDispatcher;
import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class ControlProyectos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Proyecto proyecto;
        ProyectoDAO proyectoDAO = new ProyectoDAO();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(request.getParameter("mostrar") != null){
                 // usuarios = new Usuarios(1,request.getParameter("nombre"),request.getParameter("email"), request.getParameter("password"),Integer.parseInt( request.getParameter("rol")));
                 // usuaruirsDAO.InsertarUsuarios(usuarios);
               request.setAttribute("DatosProyectos", proyectoDAO.MostrarProyecto());
             request.getRequestDispatcher("Pages_Proyecto/Dashboar_Proyecto.jsp").forward(request, response);
             
           }
           if(request.getParameter("guardar") != null){
                 // usuarios = new Usuarios(1,request.getParameter("nombre"),request.getParameter("email"), request.getParameter("password"),Integer.parseInt( request.getParameter("rol")));
                 // usuaruirsDAO.InsertarUsuarios(usuarios);
                 String NombreProyecto=request.getParameter("nombre");
                 String jefe=request.getParameter("jefe");
                 String estado=request.getParameter("estado");
                 String fechaInicio=request.getParameter("fechaInicio");
                 String fechaFinal=request.getParameter("fechaFinal");
                 //decripcion
                 String Enunciado =request.getParameter("Enunciado");
                 String Objetivo =request.getParameter("Objetivo");
                 String Resultados =request.getParameter("Resultados");
                 //concatenacion de Descripcion 
                 String Deccripcion= " Enunciado:" + Enunciado +" Obejtivo" + Objetivo +" Resultados: "+ Resultados;
                 //acceso a las entidades  y DAO
                 /*
                 empleados = new  Empleados(1,name,lastname,Integer.parseInt(cargo),tel,direc,IdUser);
            usuaruirsDAO.InsertarUsuarios(usuarios);
             empleadoDAO.InsertarEmpleados(empleados);
                 */
                 proyecto = new Proyecto(1,estado,Integer.parseInt(jefe),NombreProyecto,Deccripcion,fechaInicio,fechaFinal);
                 proyectoDAO.Insertarproyectos(proyecto);
              response.getWriter().println(
      "<!DOCTYPE html>" +
        "<html>" +
        "<head>" +
        "<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>" +
        "</head>" +
        "<body>" +
        "<script type=\"text/javascript\">" +
        "Swal.fire({" +
        "  title: '¡Éxito!'," +
        "  text: 'El cargo ha sido guardado exitosamente.'," +
        "  icon: 'success'," +
        "  confirmButtonText: 'Aceptar'" +
        "}).then((result) => {" +
        "  if (result.isConfirmed) {" +
        "    window.location.href = '../html/Proyectos.jsp';" +
        "  }" +
        "});" +
        "</script>" +
        "</body>" +
        "</html>"
    );
     //
           }
           //modificar
           if(request.getParameter("modificar") != null){
                 // usuarios = new Usuarios(1,request.getParameter("nombre"),request.getParameter("email"), request.getParameter("password"),Integer.parseInt( request.getParameter("rol")));
                 // usuaruirsDAO.InsertarUsuarios(usuarios);
                 int id=Integer.parseInt(request.getParameter("id"));
                 String NombreProyecto=request.getParameter("nombre");
                 String jefe=request.getParameter("jefe");
                 String estado=request.getParameter("estado");
                 String fechaInicio=request.getParameter("fechaInicio");
                 String fechaFinal=request.getParameter("fechaFinal");
                 //decripcion
                 String Enunciado =request.getParameter("Enunciado");
                 String Objetivo =request.getParameter("Objetivo");
                 String Resultados =request.getParameter("Resultados");
                 //concatenacion de Descripcion 
                 String Deccripcion= " Enunciado:" + Enunciado +" Obejtivo" + Objetivo +" Resultados: "+ Resultados;
                 //acceso a las entidades  y DAO
                 /*
                 empleados = new  Empleados(1,name,lastname,Integer.parseInt(cargo),tel,direc,IdUser);
            usuaruirsDAO.InsertarUsuarios(usuarios);
             empleadoDAO.InsertarEmpleados(empleados);
                 */
                 proyecto = new Proyecto(id,estado,Integer.parseInt(jefe),NombreProyecto,Deccripcion,fechaInicio,fechaFinal);
                 proyectoDAO.ModificarProyectos(proyecto);
              response.getWriter().println(
      "<!DOCTYPE html>" +
        "<html>" +
        "<head>" +
        "<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>" +
        "</head>" +
        "<body>" +
        "<script type=\"text/javascript\">" +
        "Swal.fire({" +
        "  title: '¡Éxito!'," +
        "  text: 'El cargo ha sido guardado exitosamente.'," +
        "  icon: 'success'," +
        "  confirmButtonText: 'Aceptar'" +
        "}).then((result) => {" +
        "  if (result.isConfirmed) {" +
        "    window.location.href = '';" +
        "  }" +
        "});" +
        "</script>" +
        "</body>" +
        "</html>"
    );
     //
     
           }
           //eliminar 
 if(request.getParameter("eliminar") != null){
              proyecto = new Proyecto(Integer.parseInt("id"));
                 proyectoDAO.ModificarProyectos(proyecto);
               // request.getRequestDispatcher("../admin_pages/Lista_Usuarios.jsp").forward(request, response);
                           response.getWriter().println(
      "<!DOCTYPE html>" +
        "<html>" +
        "<head>" +
        "<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>" +
        "</head>" +
        "<body>" +
        "<script type=\"text/javascript\">" +
        "Swal.fire({" +
        "  title: '¡Éxito!'," +
        "  text: 'El Usuario ha sido Eliminado exitosamente.'," +
        "  icon: 'success'," +
        "  confirmButtonText: 'Aceptar'" +
        "}).then((result) => {" +
        "  if (result.isConfirmed) {" +
        "    window.location.href = 'admin_pages/Lista_Usuarios.jsp';" +
        "  }" +
        "});" +
        "</script>" +
        "</body>" +
        "</html>"
    );  
           }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
