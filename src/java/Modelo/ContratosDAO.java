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
public class ContratosDAO {
      PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Contratos contratos;

   
    
    Connection conectar() throws SQLException, ClassNotFoundException{
        Class.forName(con.getDriver());
        return DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
    }
    /*
  CREATE TABLE `contratos` (
  `id_contrato` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_contrato` varchar(100) NOT NULL,
  `presupuesto` int,
  `estado_actual` varchar(25) DEFAULT 'activo',
  `fecha_inicio` date NOT NULL,
  `fin_creacion` date NOT NULL,
  `id_proyecto` int
);    */
    public int InsertarContratos(Contratos pContratos){
        int n = 0;
        try{
            ps = conectar().prepareStatement("INSERT INTO contratos(nombre_contrato.presupuesto,estado_actual,fecha_inicio,fin_creacion,id_proyecto) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, pContratos.getNombre_contrato());
            ps.setFloat(2, pContratos.getPresupuesto());
            ps.setString(3, pContratos.getEstado_actual());
            ps.setString(4, pContratos.getEstado_actual());
            ps.setString(5, pContratos.getFecha_inicio());
            ps.setString(6, pContratos.getFecha_finalizacion());
            ps.setInt(7, pContratos.getId_proyecto());
              
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
     /*
  CREATE TABLE `contratos` (
                  `id_contrato` int PRIMARY KEY AUTO_INCREMENT,
                `nombre_contrato` varchar(100) NOT NULL,
                `presupuesto` int,
                `estado_actual` varchar(25) DEFAULT 'activo',
                `fecha_inicio` date NOT NULL,
                `fin_creacion` date NOT NULL,
                `id_proyecto` int
              );
*/
    public int ModificarContratos(Contratos pContratos){
        int n = 0;
        try{
            ps = conectar().prepareStatement("UPDATE Cargo SET nombre_contrato=?,presupuesto=?,estado_actual=?,fecha_inicio=?,fin_creacion=?,id_proyecto=?, WHERE id_contrato=?");
           ps.setString(1, pContratos.getNombre_contrato());
            ps.setFloat(2, pContratos.getPresupuesto());
            ps.setString(3, pContratos.getEstado_actual());
            ps.setString(4, pContratos.getEstado_actual());
            ps.setString(5, pContratos.getFecha_inicio());
            ps.setString(6, pContratos.getFecha_finalizacion());
            ps.setInt(7, pContratos.getId_proyecto());
            ps.setInt(8, pContratos.getId_contrato());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    /*
  CREATE TABLE `contratos` (
                  `id_contrato` int PRIMARY KEY AUTO_INCREMENT,
                `nombre_contrato` varchar(100) NOT NULL,
                `presupuesto` int,
                `estado_actual` varchar(25) DEFAULT 'activo',
                `fecha_inicio` date NOT NULL,
                `fin_creacion` date NOT NULL,
                `id_proyecto` int
              );
*/
    public int Eliminarcontratos(Contratos pContratos){
        int n = 0;
        try{
            ps = conectar().prepareStatement("DELETE FROM contratos WHERE id_contrato=?");
            ps.setInt(1, pContratos.getId_contrato());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
      /*
  CREATE TABLE `contratos` (
                  `id_contrato` int PRIMARY KEY AUTO_INCREMENT,
                `nombre_contrato` varchar(100) NOT NULL,
                `presupuesto` int,
                `estado_actual` varchar(25) DEFAULT 'activo',
                `fecha_inicio` date NOT NULL,
                `fin_creacion` date NOT NULL,
                `id_proyecto` int
              );
*/
    public ArrayList<Contratos> Mostrarcontratos(){
        ArrayList<Contratos> ar = new ArrayList<Contratos>();
        try{
            ps = conectar().prepareStatement("SELECT * FROM contratos");
            rs = ps.executeQuery();
            while(rs.next()){
                contratos = new Contratos(rs.getInt(1), rs.getString(2),rs.getFloat(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                ar.add(contratos);
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
    public ArrayList<Contratos> BuscarcontratosNombre(String texto){
        ArrayList<Contratos> ar = new ArrayList<Contratos>();
        try{
            String sql = "SELECT * FROM contratos ";
           
            ps = conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
     contratos = new Contratos(rs.getInt(1), rs.getString(2),rs.getFloat(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                ar.add(contratos);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }
      /*
  CREATE TABLE `contratos` (
                  `id_contrato` int PRIMARY KEY AUTO_INCREMENT,
                `nombre_contrato` varchar(100) NOT NULL,
                `presupuesto` int,
                `estado_actual` varchar(25) DEFAULT 'activo',
                `fecha_inicio` date NOT NULL,
                `fin_creacion` date NOT NULL,
                `id_proyecto` int
              );
*/
    //buscar por id
     public Contratos BuscarcontratosBuscarPorId(int pId){
        
        try{
            String sql = "SELECT * FROM contratos  WHERE id_contrato=? ";
           
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, pId);
            rs = ps.executeQuery();
            while(rs.next()){
             contratos = new Contratos(rs.getInt(1), rs.getString(2),rs.getFloat(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
        }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return contratos;
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
  CREATE TABLE `contratos` (
                  `id_contrato` int PRIMARY KEY AUTO_INCREMENT,
                `nombre_contrato` varchar(100) NOT NULL,
                `presupuesto` int,
                `estado_actual` varchar(25) DEFAULT 'activo',
                `fecha_inicio` date NOT NULL,
                `fin_creacion` date NOT NULL,
                `id_proyecto` int
              );
*/
     /*
  CREATE TABLE `contratos` (
                  `id_contrato` int PRIMARY KEY AUTO_INCREMENT,
                `nombre_contrato` varchar(100) NOT NULL,
                `presupuesto` int,
                `estado_actual` varchar(25) DEFAULT 'activo',
                `fecha_inicio` date NOT NULL,
                `fin_creacion` date NOT NULL,
                `id_proyecto` int
              );
*/
    // PARA LA GRAFICA 
public ArrayList<Contratos> ContarContratosAll() {
    ArrayList<Contratos> ar = new ArrayList<>(); // Lista que almacenará los objetos Usuarios
    try {
        // Preparar la consulta SQL
        ps = conectar().prepareStatement("SELECT COUNT(*) AS total_Contratos FROM Contratos;");
        rs = ps.executeQuery();
        
        // Obtener el valor de COUNT(*)
        if (rs.next()) {
            int totalContratos = rs.getInt("total_Contratos"); // Obtener el total de usuarios
            // Crear un objeto Usuarios con el total de usuarios y añadirlo a la lista
            Contratos contrato = new Contratos(totalContratos);
           // Usuarios usuario = new Usuarios(totalUsuarios);
            ar.add(contrato); // Agregar el objeto Usuarios con el total
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
/*
  CREATE TABLE `contratos` (
                  `id_contrato` int PRIMARY KEY AUTO_INCREMENT,
                `nombre_contrato` varchar(100) NOT NULL,
                `presupuesto` int,
                `estado_actual` varchar(25) DEFAULT 'activo',
                `fecha_inicio` date NOT NULL,
                `fin_creacion` date NOT NULL,
                `id_proyecto` int
              );
*/
       //lista de borrados 
       //grafica por rol 
       public ArrayList<Contratos> ContarcontratosEliminados(){
        ArrayList<Contratos> ar = new ArrayList<Contratos>();
        try{
            
              String sql = "SELECT COUNT(*) AS total_contratos_eliminados FROM usuariosEliminados;";
           
            ps = conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
              contratos = new Contratos(rs.getInt(1), rs.getString(2),rs.getFloat(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));

                ar.add(contratos);
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return ar;
    }
}
