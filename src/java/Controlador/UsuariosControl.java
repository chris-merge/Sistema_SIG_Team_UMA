/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.*;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 *
 * @author chris
 */
public class UsuariosControl extends HttpServlet {

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
           /*
             public Usuarios(int id_Usuarios, String nombre, String email, String Passwor, int id_rol) {
        this.id_Usuarios = id_Usuarios;
        this.nombre = nombre;
        this.email = email;
        this.Passwor = Passwor;
        this.id_rol = id_rol;
    }
            */
             RequestDispatcher rd;
            Usuarios usuarios;
            UsuaruirsDAO usuaruirsDAO = new UsuaruirsDAO();
            if(request.getParameter("validar") != null){
            String nombres= request.getParameter("txt_name");
            String passwor= request.getParameter("txt_passord");
             // usuarios = new Usuarios(1, nombres,"", passwor,Integer.parseInt(""));
                usuarios = new Usuarios(nombres,passwor);
                if(usuaruirsDAO.ValidarUsuario(usuarios)){
                    request.setAttribute("r", "1");
                    request.setAttribute("usr", request.getParameter("txt_name"));
                    
                }
                else{
                    request.setAttribute("r", "0");
                }
                rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
                
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