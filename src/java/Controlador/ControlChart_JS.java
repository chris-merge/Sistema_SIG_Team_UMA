/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.*;
import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

//
import java.util.HashMap;
import java.util.Map;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;

/**
 *
 * @author chris
 */
public class ControlChart_JS extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
            /* TODO output your page here. You may use following sample code. */
             //RequestDispatcher rd;
             Usuarios usuarios;
            UsuaruirsDAO usuaruirsDAO = new UsuaruirsDAO();
            //lista de roles
            Rol rol;
            RolDAO rolDAO = new RolDAO();
            //empleadps
            Empleados empleados;
            EmpleadoDAO empleadosDAO=new EmpleadoDAO();
            //conuslta de usuarios
            if(request.getParameter("userChart") != null){
                //lista de usuarios 
             ArrayList<Usuarios> ListaUser= usuaruirsDAO.MostrarUsuarios();
             //lista de roles 
             ArrayList<Rol> ListaRoles= rolDAO.MostrarRol();
             //lista de totales de usuarios
              ArrayList<Usuarios> Listatotal= usuaruirsDAO.ContarUsuariosAll();
              
             // Crea el mapa y agrega las listas
             Map<String, Object>Datos= new HashMap<>();
             Datos.put("ListaUser", ListaUser);
             Datos.put("ListaRoles", ListaRoles);
              Datos.put("Listatotal", Listatotal);
             // Convierte el mapa a JSON
             Gson gson = new Gson();
             String json = gson.toJson(Datos);
             // Enviar el JSON al cliente
             //PrintWriter out = response.getWriter();
             out.print(json);
             out.flush();
          request.getRequestDispatcher("../admin_pages/InformeUsuario.jsp").forward(request, response);
           }
            //conuslta de Empleados
               Cargo cargo;
               CargoDAO cargoDAO=new CargoDAO();
            if(request.getParameter("EmpladoChart") != null){
                //lista de usuarios 
             ArrayList<Empleados> ListaEmpleado= empleadosDAO.ContarempleadosAll();
             //lista de Cargos 
             ArrayList<Cargo> ListaCargo= cargoDAO.MostrarCargo();
              //fin del filtro
             // Crea el mapa y agrega las listas
             Map<String, Object>Datos= new HashMap<>();
             Datos.put("ListaEmpleado", ListaEmpleado);
             Datos.put("ListaCargo", ListaCargo);
             // Convierte el mapa a JSON
             Gson gson = new Gson();
             String json = gson.toJson(Datos);
             // Enviar el JSON al cliente
             //PrintWriter out = response.getWriter();
             out.print(json);
             out.flush();
          request.getRequestDispatcher("../admin_pages/InformeUsuario.jsp").forward(request, response);
           }
         //conuslta de Proyectos
         Proyecto protyecto;
         ProyectoDAO proyectoDAO = new ProyectoDAO();
                     if(request.getParameter("EmpleadoChart") != null){
                            //lista de usuarios 
                         ArrayList<Proyecto> ListaProyecto= proyectoDAO.MostrarProyecto();
                         ArrayList<Proyecto> ListaCount= proyectoDAO.ContarProyectosAll();
                         //lista de roles 
//                         ArrayList<Rol> ListaRoles= rolDAO.MostrarRol();
                         //lista de totales de usuarios
//                          ArrayList<Usuarios> Listatotal= usuaruirsDAO.ContarUsuariosAll();

                         // Crea el mapa y agrega las listas
                         Map<String, Object>Datos= new HashMap<>();
                         Datos.put("ListaProyecto", ListaProyecto);
                           Datos.put("ListaCount", ListaCount);
//                         Datos.put("ListaRoles", ListaRoles);
//                          Datos.put("Listatotal", Listatotal);
                         // Convierte el mapa a JSON
                         Gson gson = new Gson();
                         String json = gson.toJson(Datos);
                         // Enviar el JSON al cliente
                         //PrintWriter out = response.getWriter();
                         out.print(json);
                         out.flush();
                      request.getRequestDispatcher("../Pages_Proyecto/InformeProyecto.jsp").forward(request, response);
                       }   
            
            //
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
