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
public class ProyectoDAO {
     PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Proyecto proyecto;

   
    
    Connection conectar() throws SQLException, ClassNotFoundException{
        Class.forName(con.getDriver());
        return DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
    }
    /*
                                                    CREATE TABLE `proyectos` (
                                                    `id_proyecto` int PRIMARY KEY AUTO_INCREMENT,
                                                    `Estado` varchar(25),
                                                    `jefe_proyecto` int,
                                                    `nombre_proyecto` varchar(100) NOT NULL,
                                                    `descripcion` varchar(100),
                                                    `fecha_inicio` date NOT NULL,
                                                    `Fecha_Finalizacion` date NOT NULL,
                                                    `id_Decripcion` int
                                                  );
    */
    public int Insertarproyectos(Proyecto pProyecto){
        int n = 0;
        try{
            ps = conectar().prepareStatement("INSERT INTO proyectos(Estado,jefe_proyecto,nombre_proyecto,descripcion,fecha_inicio,Fecha_Finalizacion) VALUES(?,?,?,?,?,?)");
        ps.setString(1, pProyecto.getEstado());
        ps.setInt(2, pProyecto.getJefe());
       ps.setString(3, pProyecto.getNombre_proyecto());
       ps.setString(4, pProyecto.getDescripcion());
         ps.setString(5, pProyecto.getFecha_inicio());
           ps.setString(6, pProyecto.getFecha_Finalizacion());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    /*
                        REATE TABLE `proyectos` (
                                                    `id_proyecto` int PRIMARY KEY AUTO_INCREMENT,
                                                    `Estado` varchar(25),
                                                    `jefe_proyecto` int,
                                                    `nombre_proyecto` varchar(100) NOT NULL,
                                                    `fecha_inicio` date NOT NULL,
                                                    `Fecha_Finalizacion` date NOT NULL,
                                                    `id_Decripcion` int
                                                  );
 */
    public int ModificarProyectos(Proyecto pProyecto){
        int n = 0;
        try{
            ps = conectar().prepareStatement("UPDATE proyectos SET Estado=? , jefe_proyecto=?,nombre_proyecto=?,descripcion=?,fecha_inicio=?,Fecha_Finalizacion=? WHERE id_proyecto=?");
      ps.setString(1, pProyecto.getEstado());
        ps.setInt(2, pProyecto.getJefe());
       ps.setString(3, pProyecto.getNombre_proyecto());
       ps.setString(4, pProyecto.getDescripcion());
         ps.setString(5, pProyecto.getFecha_inicio());
           ps.setString(6, pProyecto.getFecha_Finalizacion());
           
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    /*
                        REATE TABLE `proyectos` (
                                                    `id_proyecto` int PRIMARY KEY AUTO_INCREMENT,
                                                    `Estado` varchar(25),
                                                    `jefe_proyecto` int,
                                                    `nombre_proyecto` varchar(100) NOT NULL,
                                                    `fecha_inicio` date NOT NULL,
                                                    `Fecha_Finalizacion` date NOT NULL,
                                                    `id_Decripcion` int
                                                  );
 */
    public int EliminarEquipo(Proyecto pProyecto){
        int n = 0;
        try{
            ps = conectar().prepareStatement("DELETE FROM proyectos WHERE id_proyecto=?");
            ps.setInt(1, pProyecto.getId_proyeto());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
     /*
                           
                                                                                        CREATE TABLE `proyectos` (
                                                                     `id_proyecto` int PRIMARY KEY AUTO_INCREMENT,
                                                                     `Estado` varchar(25),
                                                                     `jefe_proyecto` int,
                                                                     `nombre_proyecto` varchar(100) NOT NULL,
                                                                     `descripcion` varchar(600),
                                                                     `fecha_inicio` date NOT NULL,
                                                                     `Fecha_Finalizacion` date NOT NULL
                                                                   );
 **/
    public ArrayList<Proyecto> MostrarProyecto(){
        ArrayList<Proyecto> ar = new ArrayList<Proyecto>();
        try{
            ps = conectar().prepareStatement("select * from Proyectos");
            rs = ps.executeQuery();
            while(rs.next()){
              proyecto = new Proyecto(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
              ar.add(proyecto);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }    
    /*
    
    */
    public ArrayList<Proyecto> BuscarProyectoNombre(String texto){
        ArrayList<Proyecto> ar = new ArrayList<Proyecto>();
        try{
            String sql = "SELECT * FROM proyectos ";
           
            ps = conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
      proyecto = new Proyecto(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                ar.add(proyecto);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }
     /*
                       REATE TABLE `proyectos` (
                                                    `id_proyecto` int PRIMARY KEY AUTO_INCREMENT,
                                                    `Estado` varchar(25),
                                                    `jefe_proyecto` int,
                                                    `nombre_proyecto` varchar(100) NOT NULL,
                                                    `fecha_inicio` date NOT NULL,
                                                    `Fecha_Finalizacion` date NOT NULL,
                                                    `id_Decripcion` int
                                                  );
 **/
    //buscar por id
     public Proyecto BuscarProyectoBuscarPorId(int pId){
        
        try{
            String sql = "SELECT * FROM Proyecto  WHERE id_proyecto=? ";
           
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, pId);
            rs = ps.executeQuery();
            while(rs.next()){
proyecto = new Proyecto(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));

            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return proyecto;
    }
    /*
      public Producto ObtenerProductoPorId(int pId){
        try{
            ps = conectar().prepareStatement("SELECT * FROM Producto p INNER JOIN "
                    + "Marca m ON p.IdMarca=m.Id WHERE p.Id=?;");
            ps.setInt(1, pId);
            rs = ps.executeQuery();
            while(rs.next()){
                marca = new Marca(rs.getInt("m.Id"), rs.getString("m.Nombre"));
                producto = new Producto(rs.getInt("p.Id"), rs.getString("p.Nombre"), 
                        rs.getFloat("p.Precio"), marca);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return producto;
    }
    */
    
    // PARA LA GRAFICA 
public ArrayList<Proyecto> ContarProyectosAll() {
    ArrayList<Proyecto> ar = new ArrayList<>(); // Lista que almacenará los objetos Usuarios
    try {
        // Preparar la consulta SQL
        ps = conectar().prepareStatement("SELECT COUNT(*) AS total_Proyecto FROM Proyecto;");
        rs = ps.executeQuery();
        
        // Obtener el valor de COUNT(*)
        if (rs.next()) {
            int totalProyecto = rs.getInt("total_Proyecto"); // Obtener el total de usuarios
            // Crear un objeto Usuarios con el total de usuarios y añadirlo a la lista
            Proyecto proyecto = new Proyecto(totalProyecto);
           // Usuarios usuario = new Usuarios(totalUsuarios);
            ar.add(proyecto); // Agregar el objeto Usuarios con el total
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
       //grafica por rol 
       public ArrayList<Proyecto> ContarProyectoEliminados(){
        ArrayList<Proyecto> ar = new ArrayList<Proyecto>();
        try{
            
              String sql = "SELECT COUNT(*) AS total_usuarios_eliminados FROM usuariosEliminados;";
           
            ps = conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
    proyecto = new Proyecto(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));      
  
                ar.add(proyecto);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }
}
