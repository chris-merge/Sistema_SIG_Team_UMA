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
public class ControlCargo extends HttpServlet {

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
          Cargo cargo;
          CargoDAO cargoDAO =new CargoDAO();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           if(request.getParameter("guardar") != null){
            cargo = new Cargo(1,request.getParameter("nombreCargo"));
            cargoDAO.InsertarCargo(cargo);
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
