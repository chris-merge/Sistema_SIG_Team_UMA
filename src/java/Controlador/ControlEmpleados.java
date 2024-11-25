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
public class ControlEmpleados extends HttpServlet {

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
        RequestDispatcher rd;
        Empleados empleados;
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        //usuario
         Usuarios usuarios;
         UsuaruirsDAO usuaruirsDAO = new UsuaruirsDAO();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //Lista de empleados 
            if(request.getParameter("mostrar") != null){
              //envio de lista de  Usuarios
               request.setAttribute("DatosEmpleados", empleadoDAO.MostrarEmpleado());
               //envio de datos de roles 
               
                request.getRequestDispatcher("admin_pages/Empleados_dasboard.jsp").forward(request, response);
           }
            //fin de mostrar
           if(request.getParameter("guardar") != null){
            usuarios = new Usuarios(1,request.getParameter("user"),request.getParameter("email"), request.getParameter("password"),Integer.parseInt( request.getParameter("rol")));
            String correo=request.getParameter("email");
            String name=request.getParameter("nombre");
             String lastname=request.getParameter("apellido");
             String cargo=request.getParameter("cargo"); 
             String tel=request.getParameter("telefono");
             String direc=request.getParameter("direccion"); 
             //busqueda de usuario
              usuaruirsDAO.InsertarUsuarios(usuarios);
             String SechUser=request.getParameter("user");
             ArrayList<Usuarios>Lista=usuaruirsDAO.BuscarUsuarioNombre(SechUser);
             Usuarios considencia= null;
               for (Usuarios U:Lista) {
                   if (U.getEmail().equals(correo)==true) {
                       considencia=U;
                   }
               }
               int IdUser=considencia.getId_Usuarios();
             empleados = new  Empleados(1,name,lastname,Integer.parseInt(cargo),tel,direc,IdUser);
             empleadoDAO.InsertarEmpleados(empleados);
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
        "    window.location.href = 'pages_Empleados/AgregarEmpleados.jsp';" +
        "  }" +
        "});" +
        "</script>" +
        "</body>" +
        "</html>"
    );
     //
    }
    //fin de if
    //metodo de modificar modificar
    if(request.getParameter("modificar") != null){
           // cargo = new Cargo(1,request.getParameter("nombre"));
            //cargoDAO.InsertarCargo(cargo);
            //request.getParameter("NombreuSER"),request.getParameter("gmail"),request.getParameter("pass"),
           // usuarios = new Usuarios(1,request.getParameter("user"),request.getParameter("email"), request.getParameter("password"),Integer.parseInt( request.getParameter("rol")));
            String correo=request.getParameter("email");
            String name=request.getParameter("nombre");
             String lastname=request.getParameter("apellido");
             String cargo=request.getParameter("cargo"); 
             String tel=request.getParameter("telefono");
             String direc=request.getParameter("direccion"); 
             //busqueda ID de usuarios
             int IdUser=Integer.parseInt(request.getParameter("id_user"));
             int idEmpleado=Integer.parseInt(request.getParameter("idEmpleado"));
            // ArrayList<Usuarios>Lista=usuaruirsDAO.BuscarUsuarioNombre(SechUser);
            // Usuarios considencia= null;
              /* for (Usuarios U:Lista) {
                   if (U.getEmail().equals(correo)==true) {
                       considencia=U;
                   }
               }
               int IdUser=considencia.getId_Usuarios();
            */
             empleados = new  Empleados(idEmpleado,name,lastname,Integer.parseInt(cargo),tel,direc,IdUser);
           // usuaruirsDAO.InsertarUsuarios(usuarios);
             empleadoDAO.ModificarEmpleado(empleados);
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
        "    window.location.href = 'pages_Empleados/AgregarEmpleados.jsp';" +
        "  }" +
        "});" +
        "</script>" +
        "</body>" +
        "</html>"
    );
     //
    }
    //MEDODO ELIMINAR
    if(request.getParameter("eliminar") != null){
         empleados = new Empleados(Integer.parseInt(request.getParameter("id")),"","",0,"","",0);
          empleadoDAO.EliminarEmpleado(empleados);
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
        "  text: 'Se a eliminado exitosamente.'," +
        "  icon: 'success'," +
        "  confirmButtonText: 'Aceptar'" +
        "}).then((result) => {" +
        "  if (result.isConfirmed) {" +
        "    window.location.href = 'pages_Empleados/AgregarEmpleados.jsp';" +
        "  }" +
        "});" +
        "</script>" +
        "</body>" +
        "</html>"
    );
     //
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
