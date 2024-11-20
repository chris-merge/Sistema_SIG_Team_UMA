/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class Team_ProyectoDAO {
      PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Equipo equipo;
    Team_Proyecto team_Proyecto;
   
    
    Connection conectar() throws SQLException, ClassNotFoundException{
        Class.forName(con.getDriver());
        return DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
    }
    /*
                                                            CREATE TABLE Team_Proyecto(
                                                          Idteam int not null,
                                                          `id_proyecto_team` int NOT NULL,
                                                            `id_empleado_team` int NOT NULL,
                                                            FOREIGN KEY (`id_proyecto_team`) REFERENCES `equipos`(`id_equipo`),
                                                            FOREIGN KEY (`id_empleado_team`) REFERENCES `empleados`(`id_persona`)
                                                          );  
    */
    public int InsertarTeam_Proyecto(Team_Proyecto pTeam_Proyecto){
        int n = 0;
        try{
            ps = conectar().prepareStatement("INSERT INTO Team_Proyecto(Idteam,id_empleado_team,id_proyecto) VALUES(?,?,?)");
            ps.setInt(1, pTeam_Proyecto.getIdteam());
             ps.setInt(2, pTeam_Proyecto.getId_equipo());
              ps.setInt(3, pTeam_Proyecto.getId_empleado_team());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
   /*
                                                            CREATE TABLE Team_Proyecto(
                                                          Idteam int not null,
                                                          `id_proyecto_team` int NOT NULL,
                                                            `id_empleado_team` int NOT NULL,
                                                            FOREIGN KEY (`id_proyecto_team`) REFERENCES `equipos`(`id_equipo`),
                                                            FOREIGN KEY (`id_empleado_team`) REFERENCES `empleados`(`id_persona`)
                                                          );  
    */
    public int ModificarTeam_Proyecto(Team_Proyecto pTeam_Proyecto){
        int n = 0;
        try{
            ps = conectar().prepareStatement("UPDATE Team_Proyecto SET id_proyecto_team=?,id_empleado_team=?  WHERE Idteam=?");
          ps.setInt(1, pTeam_Proyecto.getIdteam());
             ps.setInt(2, pTeam_Proyecto.getId_equipo());
              ps.setInt(3, pTeam_Proyecto.getId_empleado_team());
               ps.setInt(4, pTeam_Proyecto.getIdteam());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
   /*
                                                            CREATE TABLE Team_Proyecto(
                                                          Idteam int not null,
                                                          `id_proyecto_team` int NOT NULL,
                                                            `id_empleado_team` int NOT NULL,
                                                            FOREIGN KEY (`id_proyecto_team`) REFERENCES `equipos`(`id_equipo`),
                                                            FOREIGN KEY (`id_empleado_team`) REFERENCES `empleados`(`id_persona`)
                                                          );  
    */
    public int EliminarTeam_Proyecto(Team_Proyecto pTeam_Proyecto){
        int n = 0;
        try{
            ps = conectar().prepareStatement("DELETE FROM Team_Proyecto WHERE Idteam=?");
            ps.setInt(1, pTeam_Proyecto.getIdteam());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
     /*
                                                            CREATE TABLE Team_Proyecto(
                                                          Idteam int not null,
                                                          `id_proyecto_team` int NOT NULL,
                                                            `id_empleado_team` int NOT NULL,
                                                            FOREIGN KEY (`id_proyecto_team`) REFERENCES `equipos`(`id_equipo`),
                                                            FOREIGN KEY (`id_empleado_team`) REFERENCES `empleados`(`id_persona`)
                                                          );  
    */
    public ArrayList<Team_Proyecto> MostrarTeam_Proyecto(){
        ArrayList<Team_Proyecto> ar = new ArrayList<Team_Proyecto>();
        try{
            ps = conectar().prepareStatement("SELECT * FROM Equipo");
            rs = ps.executeQuery();
            while(rs.next()){
                team_Proyecto = new Team_Proyecto(rs.getInt(1), rs.getInt(2),rs.getInt(3));
                ar.add(team_Proyecto);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }    
      /*
                                                            CREATE TABLE Team_Proyecto(
                                                          Idteam int not null,
                                                          `id_proyecto_team` int NOT NULL,
                                                            `id_empleado_team` int NOT NULL,
                                                            FOREIGN KEY (`id_proyecto_team`) REFERENCES `equipos`(`id_equipo`),
                                                            FOREIGN KEY (`id_empleado_team`) REFERENCES `empleados`(`id_persona`)
                                                          );  
    */
    public ArrayList<Team_Proyecto> BuscarTeam_ProyectoNombre(String texto){
        ArrayList<Team_Proyecto> ar = new ArrayList<Team_Proyecto>();
        try{
            String sql = "SELECT * FROM Team_Proyecto ";
           
            ps = conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                 team_Proyecto = new Team_Proyecto(rs.getInt(1), rs.getInt(2),rs.getInt(3));
                ar.add(team_Proyecto);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }
      /*
                                                            CREATE TABLE Team_Proyecto(
                                                          Idteam int not null,
                                                          `id_proyecto_team` int NOT NULL,
                                                            `id_empleado_team` int NOT NULL,
                                                            FOREIGN KEY (`id_proyecto_team`) REFERENCES `equipos`(`id_equipo`),
                                                            FOREIGN KEY (`id_empleado_team`) REFERENCES `empleados`(`id_persona`)
                                                          );  
    */
    //buscar por id
     public Team_Proyecto BuscarTeam_ProyectoBuscarPorId(int pId){
        
        try{
            String sql = "SELECT * FROM Team_Proyecto  WHERE Idteam=? ";
           
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, pId);
            rs = ps.executeQuery();
            while(rs.next()){
                 team_Proyecto = new Team_Proyecto(rs.getInt(1), rs.getInt(2),rs.getInt(3));
                      
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return team_Proyecto;
    }
     /*
                                                            CREATE TABLE Team_Proyecto(
                                                          Idteam int not null,
                                                          `id_proyecto_team` int NOT NULL,
                                                            `id_empleado_team` int NOT NULL,
                                                            FOREIGN KEY (`id_proyecto_team`) REFERENCES `equipos`(`id_equipo`),
                                                            FOREIGN KEY (`id_empleado_team`) REFERENCES `empleados`(`id_persona`)
                                                          );  
    */
    // PARA LA GRAFICA 
public ArrayList<Team_Proyecto> ContarTeam_ProyectoAll() {
    ArrayList<Team_Proyecto> ar = new ArrayList<>(); // Lista que almacenará los objetos Usuarios
    try {
        // Preparar la consulta SQL
        ps = conectar().prepareStatement("SELECT COUNT(*) AS total_proyecto FROM Team_Proyecto;");
        rs = ps.executeQuery();
        
        // Obtener el valor de COUNT(*)
        if (rs.next()) {
            int total_proyecto = rs.getInt("total_proyecto"); // Obtener el total de usuarios
            // Crear un objeto Usuarios con el total de usuarios y añadirlo a la lista
            Team_Proyecto team_Proyecto = new Team_Proyecto(total_proyecto);
           // Usuarios usuario = new Usuarios(totalUsuarios);
            ar.add(team_Proyecto); // Agregar el objeto Usuarios con el total
        }

        // Cerrar los recursos
        ps.close();
        rs.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return ar; // Retornar la lista con el objeto Usuarios que contiene el total
}


     
     //
     
     //grafica por rol 
     /*  public ArrayList<Cargo> ContarUsuariosRol(int pId){
        ArrayList<Cargo> ar = new ArrayList<Cargo>();
        try{
            
              String sql = "SELECT id_rol, COUNT(*) AS cantidad_usuarios FROM Usuarios WHERE id_rol = ? GROUP BY id_rol;";
           
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, pId);
            rs = ps.executeQuery();
            while(rs.next()){
                usuario = new Usuarios(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(1));
                ar.add(usuario);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }
*/
       //lista de borrados 
 /*
                           
                            
                          CREATE TABLE `equipos` (
  `id_equipo` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_equipo` varchar(100) NOT NULL,
  `id_proyecto` int,
  `id_empleado` int
););
 **/
       //grafica por rol 
       public ArrayList<Team_Proyecto> ContarTeam_ProyectoEliminados(){
        ArrayList<Team_Proyecto> ar = new ArrayList<Team_Proyecto>();
        try{
            
              String sql = "SELECT COUNT(*) AS total_usuarios_eliminados FROM usuariosEliminados;";
           
            ps = conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
              team_Proyecto = new Team_Proyecto(rs.getInt(1), rs.getInt(2),rs.getInt(3));
                ar.add(team_Proyecto);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }
}
