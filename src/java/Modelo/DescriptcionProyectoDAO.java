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
public class DescriptcionProyectoDAO {
 
     PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
DescriptcionProyecto desproyecto;
   
    
    Connection conectar() throws SQLException, ClassNotFoundException{
        Class.forName(con.getDriver());
        return DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
    }
    /*
                                                CREATE TABLE `DescripcionProyecto` (
                                               `Id_Descripcion` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                               `Enunciado` Varchar(400),
                                               `objetivo` varchar(250),
                                               `ResultadosEsperados` varchar(400)
);
    */
    public int InsertarDescripcionProyecto(DescriptcionProyecto pdesproyecto){
        int n = 0;
        try{
            ps = conectar().prepareStatement("INSERT INTO DescripcionProyecto(Enunciado,objetivo,ResultadosEsperados) VALUES(?,?,?)");
            ps.setString(1, pdesproyecto.getEnunciado());
             ps.setString(2, pdesproyecto.getObjetivo());
              ps.setString(3, pdesproyecto.getResultadoEsperados());
             
              
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    /*
                           
                                                CREATE TABLE `DescripcionProyecto` (
                                               `Id_Descripcion` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                               `Enunciado` Varchar(400),
                                               `objetivo` varchar(250),
                                               `ResultadosEsperados` varchar(400)
 */
    public int ModificarUsuarios(DescriptcionProyecto pdesproyecto){
        int n = 0;
        try{
            ps = conectar().prepareStatement("UPDATE DescripcionProyecto SET Enunciado=?, objetivo=?,ResultadosEsperados=? WHERE Id_Descripcion=?");
            ps.setString(1, pdesproyecto.getEnunciado());
             ps.setString(2, pdesproyecto.getObjetivo());
              ps.setString(3, pdesproyecto.getResultadoEsperados());
               ps.setInt(4, pdesproyecto.getId_Descripcion());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
     /*
                           
                                                CREATE TABLE `DescripcionProyecto` (
                                               `Id_Descripcion` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                               `Enunciado` Varchar(400),
                                               `objetivo` varchar(250),
                                               `ResultadosEsperados` varchar(400)
 */
    public int EliminarDescriptcionProyecto(DescriptcionProyecto pdesproyecto){
        int n = 0;
        try{
            ps = conectar().prepareStatement("DELETE FROM DescripcionProyecto WHERE Id_Descripcion=?");
            ps.setInt(1, pdesproyecto.getId_Descripcion());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
     /*
                             CREATE TABLE `DescripcionProyecto` (
                                               `Id_Descripcion` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                               `Enunciado` Varchar(400),
                                               `objetivo` varchar(250),
                                               `ResultadosEsperados` varchar(400)
 **/
    public ArrayList<DescriptcionProyecto> MostrarEmpleado(){
        ArrayList<DescriptcionProyecto> ar = new ArrayList<DescriptcionProyecto>();
        try{
            ps = conectar().prepareStatement("SELECT * FROM empleados");
            rs = ps.executeQuery();
            while(rs.next()){
                desproyecto = new DescriptcionProyecto(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
                ar.add(desproyecto);
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
                             CREATE TABLE `DescripcionProyecto` (
                                               `Id_Descripcion` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
                                               `Enunciado` Varchar(400),
                                               `objetivo` varchar(250),
                                               `ResultadosEsperados` varchar(400)
 **/
    public ArrayList<DescriptcionProyecto> BuscarEmpleadoNombre(String texto){
        ArrayList<DescriptcionProyecto> ar = new ArrayList<DescriptcionProyecto>();
        try{
            String sql = "SELECT * FROM empleados ";
           
            ps = conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
               desproyecto = new DescriptcionProyecto(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
                ar.add(desproyecto);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }
    
    //buscar por id
     public DescriptcionProyecto BuscarEmpleadoBuscarPorId(int pId){
        
        try{
            String sql = "SELECT * FROM empleados  WHERE id_persona=? ";
           
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, pId);
            rs = ps.executeQuery();
            while(rs.next()){
         desproyecto = new DescriptcionProyecto(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return desproyecto;
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
public ArrayList<DescriptcionProyecto> ContarUsuariosAll() {
    ArrayList<DescriptcionProyecto> ar = new ArrayList<>(); // Lista que almacenará los objetos Usuarios
    try {
        // Preparar la consulta SQL
        ps = conectar().prepareStatement("SELECT COUNT(*) AS total_usuarios FROM Usuarios;");
        rs = ps.executeQuery();
        
        // Obtener el valor de COUNT(*)
        if (rs.next()) {
            int totalEmpleado = rs.getInt("total_usuarios"); // Obtener el total de usuarios
            // Crear un objeto Usuarios con el total de usuarios y añadirlo a la lista
            DescriptcionProyecto despro = new DescriptcionProyecto(totalEmpleado);
           // Usuarios usuario = new Usuarios(totalUsuarios);
            ar.add(despro); // Agregar el objeto Usuarios con el total
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
       public ArrayList<DescriptcionProyecto> ContarEmpleadoEliminados(){
        ArrayList<DescriptcionProyecto> ar = new ArrayList<DescriptcionProyecto>();
        try{
            
              String sql = "SELECT COUNT(*) AS total_usuarios_eliminados FROM usuariosEliminados;";
           
            ps = conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
               desproyecto = new DescriptcionProyecto(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4));        
  
                ar.add(desproyecto);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }
}
