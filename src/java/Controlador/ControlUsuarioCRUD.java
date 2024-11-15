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
public class ControlUsuarioCRUD extends HttpServlet {

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
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            RequestDispatcher rd;
            Usuarios usuarios;
            UsuaruirsDAO usuaruirsDAO = new UsuaruirsDAO();
            RolDAO rolDAO = new RolDAO();
           
            if(request.getParameter("mostrar") != null){
              //envio de lista de  Usuarios
               request.setAttribute("DatosUsuarios", usuaruirsDAO.MostrarUsuarios());
               //envio de datos de roles 
                request.setAttribute("DatosRoles", rolDAO.MostrarRol());
                request.getRequestDispatcher("admin_pages/Lista_Usuarios.jsp").forward(request, response);
           }
if(request.getParameter("guardar") != null){
                  usuarios = new Usuarios(1,request.getParameter("nombre"),request.getParameter("email"), request.getParameter("password"),Integer.parseInt( request.getParameter("rol")));
                  usuaruirsDAO.InsertarUsuarios(usuarios);
             request.getRequestDispatcher("admin_pages/Lista_Usuarios.jsp").forward(request, response);
             
           }
//eliminar 
 if(request.getParameter("eliminar") != null){
               usuarios = new Usuarios(Integer.parseInt(request.getParameter("id")));
               usuaruirsDAO.EliminarUsuarios(usuarios);
                request.getRequestDispatcher("admin_pages/Lista_Usuarios.jsp").forward(request, response);
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
