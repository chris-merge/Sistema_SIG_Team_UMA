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
public class EmpleadoDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Cargo cargo;
    Empleados empleado;
   
    
    Connection conectar() throws SQLException, ClassNotFoundException{
        Class.forName(con.getDriver());
        return DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
    }
    /*
    CREATE TABLE `empleados` (
  `id_persona` int PRIMARY KEY,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `id_cargo` int,
  `telefono` varchar(20),
  `direccion` varchar(100),
  `id_user` int NOT NULL
);
    */
   
    public int InsertarEmpleados(Empleados pEmpleados){
        int n = 0;
        try{
           ps = conectar().prepareStatement("INSERT INTO empleados(nombre,apellido,id_cargo,telefono,direccion,id_user)VALUES(?,?,?,?,?,?)");
            ps.setString(1, pEmpleados.getNombre());
            ps.setString(2, pEmpleados.getApellido());
            ps.setInt(3, pEmpleados.getId_cargo());
            ps.setString(4, pEmpleados.getTelefono());
            ps.setString(5, pEmpleados.getDireccion());
            ps.setInt(6, pEmpleados.getId_user());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    /*
                            CREATE TABLE `empleados` (
                          `id_persona` int PRIMARY KEY,
                          `nombre` varchar(100) NOT NULL,
                          `apellido` varchar(100) NOT NULL,
                          `id_cargo` int,
                          `telefono` varchar(20),
                          `direccion` varchar(100),
                          `id_user` int NOT NULL
                        );
 */
    public int ModificarEmpleado(Empleados pEmpleado){
        int n = 0;
        try{
            ps = conectar().prepareStatement("UPDATE empleados SET nombre=?, apellido=?,id_cargo=?,telefono=?, direccion=?,id_user=? WHERE id_persona=?");
            ps.setString(1, pEmpleado.getNombre());
             ps.setString(2, pEmpleado.getApellido());
              ps.setInt(3, pEmpleado.getId_cargo());
                ps.setString(4, pEmpleado.getTelefono());
              ps.setString(5, pEmpleado.getDireccion());
               ps.setInt(6, pEmpleado.getId_user());
               ps.setInt(7, pEmpleado.getId_persona());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    
    public int EliminarEmpleado(Empleados pEmpleado){
        int n = 0;
        try{
            ps = conectar().prepareStatement("DELETE FROM empleados WHERE id_persona=?");
            ps.setInt(1, pEmpleado.getId_persona());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
     /*
                            CREATE TABLE `empleados` (
                          `id_persona` int PRIMARY KEY,
                          `nombre` varchar(100) NOT NULL,
                          `apellido` varchar(100) NOT NULL,
                          `id_cargo` int,
                          `telefono` varchar(20),
                          `direccion` varchar(100),
                          `id_user` int NOT NULL
                        );
 **/
    public ArrayList<Empleados> MostrarEmpleado(){
        ArrayList<Empleados> ar = new ArrayList<Empleados>();
        try{
            ps = conectar().prepareStatement("SELECT * FROM Empleados");
            rs = ps.executeQuery();
            while(rs.next()){
                empleado = new Empleados(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                ar.add(empleado);
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
    public ArrayList<Empleados> BuscarEmpleadoNombre(String texto){
        ArrayList<Empleados> ar = new ArrayList<Empleados>();
        try{
            String sql = "SELECT * FROM empleados ";
           
            ps = conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                 empleado = new Empleados(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                ar.add(empleado);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }
    
    //buscar por id
     public Empleados BuscarEmpleadoBuscarPorId(int pId){
        
        try{
            String sql = "SELECT * FROM empleados  WHERE id_persona=? ";
           
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, pId);
            rs = ps.executeQuery();
            while(rs.next()){
                empleado = new Empleados(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7));        
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return empleado;
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
public ArrayList<Empleados> ContarUsuariosAll() {
    ArrayList<Empleados> ar = new ArrayList<>(); // Lista que almacenará los objetos Usuarios
    try {
        // Preparar la consulta SQL
        ps = conectar().prepareStatement("SELECT COUNT(*) AS total_usuarios FROM Usuarios;");
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
       public ArrayList<Empleados> ContarEmpleadoEliminados(){
        ArrayList<Empleados> ar = new ArrayList<Empleados>();
        try{
            
              String sql = "SELECT COUNT(*) AS total_usuarios_eliminados FROM usuariosEliminados;";
           
            ps = conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
               empleado = new Empleados(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7));        
  
                ar.add(empleado);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }
}
