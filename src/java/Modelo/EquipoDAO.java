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
public class EquipoDAO {
      PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Equipo equipo;

   
    
    Connection conectar() throws SQLException, ClassNotFoundException{
        Class.forName(con.getDriver());
        return DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
    }
    /*
  CREATE TABLE `equipos` (
  `id_equipo` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_equipo` varchar(100) NOT NULL,
  `id_proyecto` int,
  `id_empleado` int
);
    */
    public int InsertarEquipo(Equipo pEquipo){
        int n = 0;
        try{
            ps = conectar().prepareStatement("INSERT INTO equipos(nombre_equipo,id_proyecto,id_empleado) VALUES(?,?,?)");
            ps.setString(1, pEquipo.getNombre_equipo());
             ps.setInt(2, pEquipo.getId_proyecto());
              ps.setInt(3, pEquipo.getId_empleado());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    /*
                         CREATE TABLE `equipos` (
  `id_equipo` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_equipo` varchar(100) NOT NULL,
  `id_proyecto` int,
  `id_empleado` int
);
 */
    public int ModificarEquipo(Equipo pEquipo){
        int n = 0;
        try{
            ps = conectar().prepareStatement("UPDATE equipos SET nombre_equipo=?,id_proyecto=?,id_empleado=?  WHERE id_equipo=?");
          ps.setString(1, pEquipo.getNombre_equipo());
             ps.setInt(2, pEquipo.getId_proyecto());
            ps.setInt(3, pEquipo.getId_empleado());
             ps.setInt(4, pEquipo.getId_equipo());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    /*
       CREATE TABLE `equipos` (
  `id_equipo` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_equipo` varchar(100) NOT NULL,
  `id_proyecto` int,
  `id_empleado` int
);
    */
    public int EliminarEquipo(Equipo pEquipo){
        int n = 0;
        try{
            ps = conectar().prepareStatement("DELETE FROM equipos WHERE id_equipo=?");
            ps.setInt(1, pEquipo.getId_equipo());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
     /*
                           
                          CREATE TABLE `equipos` (
  `id_equipo` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_equipo` varchar(100) NOT NULL,
  `id_proyecto` int,
  `id_empleado` int
););
 **/
    public ArrayList<Equipo> MostrarCargo(){
        ArrayList<Equipo> ar = new ArrayList<Equipo>();
        try{
            ps = conectar().prepareStatement("SELECT * FROM Equipo");
            rs = ps.executeQuery();
            while(rs.next()){
                equipo = new Equipo(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4));
                ar.add(equipo);
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
     /*
                           
                          CREATE TABLE `equipos` (
  `id_equipo` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_equipo` varchar(100) NOT NULL,
  `id_proyecto` int,
  `id_empleado` int
););
 **/
    public ArrayList<Equipo> BuscarEquipoNombre(String texto){
        ArrayList<Equipo> ar = new ArrayList<Equipo>();
        try{
            String sql = "SELECT * FROM Cargo ";
           
            ps = conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                 equipo = new Equipo(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4));
                ar.add(equipo);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }
     /*
                           
                            
                          CREATE TABLE `equipos` (
  `id_equipo` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_equipo` varchar(100) NOT NULL,
  `id_proyecto` int,
  `id_empleado` int
););
 **/
    //buscar por id
     public Equipo BuscarEquipoBuscarPorId(int pId){
        
        try{
            String sql = "SELECT * FROM equipos  WHERE id_equipo=? ";
           
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, pId);
            rs = ps.executeQuery();
            while(rs.next()){
                equipo = new Equipo(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4));
       
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return equipo;
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
         /*
                           
                            
                          CREATE TABLE `equipos` (
  `id_equipo` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_equipo` varchar(100) NOT NULL,
  `id_proyecto` int,
  `id_empleado` int
););
 **/
    // PARA LA GRAFICA 
public ArrayList<Equipo> ContarEquipoAll() {
    ArrayList<Equipo> ar = new ArrayList<>(); // Lista que almacenará los objetos Usuarios
    try {
        // Preparar la consulta SQL
        ps = conectar().prepareStatement("SELECT COUNT(*) AS total_equipo FROM Equipo;");
        rs = ps.executeQuery();
        
        // Obtener el valor de COUNT(*)
        if (rs.next()) {
            int totalEquipo = rs.getInt("total_equipo"); // Obtener el total de usuarios
            // Crear un objeto Usuarios con el total de usuarios y añadirlo a la lista
            Equipo equipo = new Equipo(totalEquipo);
           // Usuarios usuario = new Usuarios(totalUsuarios);
            ar.add(equipo); // Agregar el objeto Usuarios con el total
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
       public ArrayList<Equipo> ContarEmpleadoEliminados(){
        ArrayList<Equipo> ar = new ArrayList<Equipo>();
        try{
            
              String sql = "SELECT COUNT(*) AS total_usuarios_eliminados FROM usuariosEliminados;";
           
            ps = conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                equipo = new Equipo(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getInt(4));

                ar.add(equipo);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }
}
