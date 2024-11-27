/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.*;
import Modelo.Usuarios;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chris
 */
public class tControlChartjs extends HttpServlet {

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
        tInventario tinventario;
        tInventarioDAO tinventarioDAO= new tInventarioDAO();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           if(request.getParameter("inventario") != null){
                //lista de usuarios 
             ArrayList<tInventario> ListaInventario= tinventarioDAO.MostrarInventarioContado();
             //lista de roles 
//             ArrayList<Rol> ListaRoles= rolDAO.MostrarRol();
             //lista de totales de usuarios
//              ArrayList<Usuarios> Listatotal= usuaruirsDAO.ContarUsuariosAll();
              
             // Crea el mapa y agrega las listas
             Map<String, Object>Datos= new HashMap<>();
             Datos.put("ListaInventario", ListaInventario);
//             Datos.put("ListaRoles", ListaRoles);
//              Datos.put("Listatotal", Listatotal);
             // Convierte el mapa a JSON
             Gson gson = new Gson();
             String json = gson.toJson(Datos);
             // Enviar el JSON al cliente
             //PrintWriter out = response.getWriter();
             out.print(json);
             out.flush();
          request.getRequestDispatcher("../tPages_inventario/Informe_Inventario.jsp").forward(request, response);
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
