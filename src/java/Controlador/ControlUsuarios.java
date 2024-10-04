/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import Modelo.*;
/**
 *
 * @author chris
 */
public class ControlUsuarios extends HttpServlet {
    /*
    
    */
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Usuarios usuarios;
        UsuaruirsDAO usuarioDAO = new UsuaruirsDAO();
       
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           RequestDispatcher rd;
         
            if(request.getParameter("mostrar") != null){
              
               request.setAttribute("DatosEditoriales", usuarioDAO.MostrarUsuarios());
           }
            
              if(request.getParameter("buscar") != null){
                String opc = request.getParameter("rb");
                String texto = request.getParameter("txt");
               request.setAttribute("DatosEditoriales", usuarioDAO.BuscarUsuarioNombre(opc, texto));
            }
            
             if(request.getParameter("guardar") != null){
               usuarios = new Usuarios(1,request.getParameter("Nombre"),request.getParameter("Gmail"),request.getParameter("Password"),Integer.parseInt(request.getHeader("id_rol")));
             
                usuarioDAO.InsertarUsuarios(usuarios);
             
           }
             if(request.getParameter("modificar") != null){

                usuarios = new Usuarios(Integer.parseInt(request.getParameter("Id")),request.getParameter("nombre"),request.getParameter("gmail"),request.getParameter("password"),Integer.parseInt(request.getParameter("id_rol")));
                usuarioDAO.ModificarUsuarios(usuarios);
           }
             
             if(request.getParameter("eliminar") != null){
               usuarios = new Usuarios(Integer.parseInt(request.getParameter("Id")),request.getParameter("nombre"),request.getParameter("gmail"),request.getParameter("password"),Integer.parseInt(request.getParameter("id_rol")));
                usuarioDAO.EliminarUsuarios(usuarios);
           }
           rd = request.getRequestDispatcher("VistaLibros.jsp");
           rd.forward(request, response);
        }
    }
    
    /*
    
    */
    
}
