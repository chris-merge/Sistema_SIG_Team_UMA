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
public class CargoDAO {
        
    PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Cargo cargo;

   
    
    Connection conectar() throws SQLException, ClassNotFoundException{
        Class.forName(con.getDriver());
        return DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
    }
    /*
  CREATE TABLE `cargos` (
  `id_cargo` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_cargo` varchar(100) NOT NULL
);
    */
    public int InsertarCargo(Cargo pCargo){
        int n = 0;
        try{
            ps = conectar().prepareStatement("INSERT INTO cargos(nombre_cargo) VALUES(?)");
            ps.setString(1, pCargo.getNombre_cargo());
              
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    /*
                        CREATE TABLE `cargos` (
  `id_cargo` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_cargo` varchar(100) NOT NULL
);
 */
    public int Modificarcargos(Cargo pCargo){
        int n = 0;
        try{
            ps = conectar().prepareStatement("UPDATE cargos SET nombre_cargo=? WHERE id_cargo=?");
            ps.setString(1, pCargo.getNombre_cargo());
               ps.setInt(2, pCargo.getId_cargo());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    
    public int EliminarCargo(Cargo pCargo){
        int n = 0;
        try{
            ps = conectar().prepareStatement("DELETE FROM cargos WHERE id_cargo=?");
            ps.setInt(1, pCargo.getId_cargo());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
     /*
                           
                        CREATE TABLE `cargos` (
  `id_cargo` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_cargo` varchar(100) NOT NULL
);
 **/
    public ArrayList<Cargo> MostrarCargo(){
        ArrayList<Cargo> ar = new ArrayList<Cargo>();
        try{
            ps = conectar().prepareStatement("SELECT * FROM cargos");
            rs = ps.executeQuery();
            while(rs.next()){
                cargo = new Cargo(rs.getInt(1), rs.getString(2));
                ar.add(cargo);
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
    public ArrayList<Cargo> BuscarCargoNombre(String texto){
        ArrayList<Cargo> ar = new ArrayList<Cargo>();
        try{
            String sql = "SELECT * FROM Cargo ";
           
            ps = conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                 cargo = new Cargo(rs.getInt(1), rs.getString(2));
                ar.add(cargo);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }
     /*
                           
                        CREATE TABLE `cargos` (
  `id_cargo` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_cargo` varchar(100) NOT NULL
);
 **/
    //buscar por id
     public Cargo BuscarCargoBuscarPorId(int pId){
        
        try{
            String sql = "SELECT * FROM Cargo  WHERE id_cargo=? ";
           
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, pId);
            rs = ps.executeQuery();
            while(rs.next()){
                cargo = new Cargo(rs.getInt(1), rs.getString(2));        
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return cargo;
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
public ArrayList<Empleados> ContarCargoAll() {
    ArrayList<Empleados> ar = new ArrayList<>(); // Lista que almacenará los objetos Usuarios
    try {
        // Preparar la consulta SQL
        ps = conectar().prepareStatement("SELECT COUNT(*) AS total_usuarios FROM Cargo;");
        rs = ps.executeQuery();
        
        // Obtener el valor de COUNT(*)
        if (rs.next()) {
            int totalEmpleado = rs.getInt("total_usuarios"); // Obtener el total de usuarios
            // Crear un objeto Usuarios con el total de usuarios y añadirlo a la lista
            Empleados empleado = new Empleados(totalEmpleado);
           // Usuarios usuario = new Usuarios(totalUsuarios);
            ar.add(empleado); // Agregar el objeto Usuarios con el total
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
       public ArrayList<Cargo> ContarCargoEliminados(){
        ArrayList<Cargo> ar = new ArrayList<Cargo>();
        try{
            
              String sql = "SELECT COUNT(*) AS total_usuarios_eliminados FROM usuariosEliminados;";
           
            ps = conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
               cargo = new Cargo(rs.getInt(1), rs.getString(2));        
  
                ar.add(cargo);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }
}
