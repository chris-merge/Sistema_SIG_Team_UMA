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
public class ControlEquipos extends HttpServlet {

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
        Equipo equipo;
        EquipoDAO equipoDAO = new EquipoDAO();
        //team 
        Team_Proyecto team_Proyecto;
        Team_ProyectoDAO team_ProyectoDAO = new Team_ProyectoDAO();
        //Empleado
        Empleados empleado;
        EmpleadoDAO empleadosDAO = new EmpleadoDAO();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(request.getParameter("mostrar") != null){
                
               request.setAttribute("DatosListaTeam_Proyecto", team_ProyectoDAO.MostrarTeam_Proyecto());
                 // usuarios = new Usuarios(1,request.getParameter("nombre"),request.getParameter("email"), request.getParameter("password"),Integer.parseInt( request.getParameter("rol")));
                 // usuaruirsDAO.InsertarUsuarios(usuarios);
                 //variables de la tabla de equipos
//             String NEquipo=request.getParameter("nomnreEquipo");
//             int jefe=Integer.parseInt(request.getParameter("jefe"));
//               int proyecto=Integer.parseInt(request.getParameter("idProyecto"));
//                 String[] seleccionados = request.getParameterValues("team");
                 /*
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        // Simulando que los datos vienen de un formulario
        listaPersonas.add(new Persona(1, "Juan", 25));
        listaPersonas.add(new Persona(2, "María", 30));
        listaPersonas.add(new Persona(3, "Carlos", 28));
        // Guardar en la base de datos
        guardarEnBaseDeDatos(listaPersonas);
                 CREATE TABLE Team_Proyecto(
                        Idteam int not null,
                        `id_proyecto_team` int NOT NULL,
                          `id_empleado_team` int NOT NULL,
                          FOREIGN KEY (`id_proyecto_team`) REFERENCES `equipos`(`id_equipo`),
                          FOREIGN KEY (`id_empleado_team`) REFERENCES `empleados`(`id_persona`)
                        );
                        /busqueda de usuario
             String SechUser=request.getParameter("user");
             ArrayList<Usuarios>Lista=usuaruirsDAO.BuscarUsuarioNombre(SechUser);
             Usuarios considencia= null;
               for (Usuarios U:Lista) {
                   if (U.getEmail().equals(correo)==true) {
                       considencia=U;
                   }
               }
               int IdUser=considencia.getId_Usuarios();
 */
//                 equipo= new Equipo(1,NEquipo);
//                 ArrayList<Equipo> ListaEquipo = equipoDAO.IdUltimoEquipo();
//                 Equipo IdEquipo= null;
//                 for (Equipo E:ListaEquipo) {
//                    IdEquipo=E;
//                }
//                 //Id de proyecto de para insetar en TEAM
//                 int IdEquiposTeam=IdEquipo.getId_equipo();
//                 
//                for(int i = 0; i < seleccionados.length; i++) {
//                      ArrayList<Empleados> LsitaEmpleados= new ArrayList<>();
//                     for (String id : seleccionados) {
////                response.getWriter().println("<p>ID: " + id + "</p>");
//                   team_Proyecto =new  Team_Proyecto(IdEquiposTeam,IdEquiposTeam,Integer.parseInt(id));
//                 
//            }
//                }
               //request.setAttribute("DatosListaTeam_Proyecto", team_ProyectoDAO.MostrarTeam_Proyecto());
             request.getRequestDispatcher("admin_pages/Dashboar_Equipos.jsp").forward(request, response);
             
           }
            
            //guardar
            if (request.getParameter("guardar")!= null) {
                 String NEquipo=request.getParameter("nomnreEquipo");
             int jefe=Integer.parseInt(request.getParameter("jefe"));
               int proyecto=Integer.parseInt(request.getParameter("idProyecto"));
                 String[] seleccionados = request.getParameterValues("team");
                 /*
        ArrayList<Persona> listaPersonas = new ArrayList<>();
        // Simulando que los datos vienen de un formulario
        listaPersonas.add(new Persona(1, "Juan", 25));
        listaPersonas.add(new Persona(2, "María", 30));
        listaPersonas.add(new Persona(3, "Carlos", 28));
        // Guardar en la base de datos
        guardarEnBaseDeDatos(listaPersonas);
                 CREATE TABLE Team_Proyecto(
                        Idteam int not null,
                        `id_proyecto_team` int NOT NULL,
                          `id_empleado_team` int NOT NULL,
                          FOREIGN KEY (`id_proyecto_team`) REFERENCES `equipos`(`id_equipo`),
                          FOREIGN KEY (`id_empleado_team`) REFERENCES `empleados`(`id_persona`)
                        );
                        /busqueda de usuario
             String SechUser=request.getParameter("user");
             ArrayList<Usuarios>Lista=usuaruirsDAO.BuscarUsuarioNombre(SechUser);
             Usuarios considencia= null;
               for (Usuarios U:Lista) {
                   if (U.getEmail().equals(correo)==true) {
                       considencia=U;
                   }
               }
               int IdUser=considencia.getId_Usuarios();
 */
                 equipo= new Equipo(1,NEquipo);
                 equipoDAO.InsertarEquipo(equipo);
                 ArrayList<Equipo> ListaEquipo = equipoDAO.IdUltimoEquipo();
                 Equipo IdEquipo= null;
                 for (Equipo E:ListaEquipo) {
                    IdEquipo=E;
                }
                 //Id de proyecto de para insetar en TEAM
                 int IdEquiposTeam=IdEquipo.getId_equipo();
                 
                for(int i = 0; i < seleccionados.length; i++) {
                      ArrayList<Empleados> LsitaEmpleados= new ArrayList<>();
                     for (String id : seleccionados) {
//                response.getWriter().println("<p>ID: " + id + "</p>");
                   team_Proyecto =new  Team_Proyecto(1,IdEquiposTeam,Integer.parseInt(id));
                   team_ProyectoDAO.InsertarTeam_Proyecto(team_Proyecto);
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
        "    window.location.href = 'pages_Equipos/AgregarEquipo.jsp';" +
        "  }" +
        "});" +
        "</script>" +
        "</body>" +
        "</html>"
    );
            }
           }
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
