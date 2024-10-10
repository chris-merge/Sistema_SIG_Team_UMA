/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Usuarios;
import Modelo.UsuaruirsDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

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
        Usuarios usuarios;
        UsuaruirsDAO usuarioDAO = new UsuaruirsDAO();
        try (PrintWriter out = response.getWriter()) {
             RequestDispatcher rd;
            if(request.getParameter("validar") != null){
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuariosControl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuariosControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
             String txt_name = request.getParameter("txt_name");
             // request.setAttribute("Validar", usuarioDAO.BuscarUsuarioNombre(texto));
             var SQL= usuarioDAO.BuscarUsuarioNombre(txt_name);
             var List=SQL.forEach(usuarios->{usuarios.getNombre(),});
                if (!=null) {
                    
             ArrayList<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
             /*
               <% for(Autores A:listaAutores){ %>
                            <option value="<%=A.getIdAutor()%>"><%=A.getNombre()%></option>
                        <% } %>
             */
                    for (Usuarios U: listaUsuarios) {
                        if (txt_name == U.getNombre()) {
                            rd = request.getRequestDispatcher("html/Home.jsp");
           rd.forward(request, response);
                        }
                    }
                }
               
        }else  {
                    out.println("<h1>fallo</h1>");
            }
           /* rd = request.getRequestDispatcher("index.html");
           rd.forward(request, response);
            */
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
