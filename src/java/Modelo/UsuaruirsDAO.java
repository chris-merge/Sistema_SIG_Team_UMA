/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
*/
import java.sql.*;
import java.util.*;

/**
 *
 * @author chris
 */
public class UsuaruirsDAO {
    /*
    
    */
    PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Usuarios usuario;
    
    Connection conectar() throws SQLException, ClassNotFoundException{
        Class.forName(con.getDriver());
        return DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
    }
    
    public int InsertarUsuarios(Usuarios pUsuarios){
        int n = 0;
        try{
            ps = conectar().prepareStatement("INSERT INTO Usuarios(nombre,email,passwor,id_rol) VALUES(?,?,?,?)");
            ps.setString(1, pUsuarios.getNombre());
             ps.setString(2, pUsuarios.getEmail());
              ps.setString(3, pUsuarios.getPasswor());
                ps.setInt(4, pUsuarios.getId_rol());
              
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    
    public int ModificarUsuarios(Usuarios pUsuarios){
        int n = 0;
        try{
            ps = conectar().prepareStatement("UPDATE Usuarios SET nombre=?, email=?,passwor=?,id_rol=? WHERE id_Usuarios=?");
              ps.setString(1, pUsuarios.getNombre());
             ps.setString(2, pUsuarios.getEmail());
              ps.setString(3, pUsuarios.getPasswor());
               ps.setInt(4, pUsuarios.getId_Usuarios());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    
    public int EliminarUsuarios(Usuarios pUsuarios){
        int n = 0;
        try{
            ps = conectar().prepareStatement("DELETE FROM Usuarios WHERE id_Usuarios=?");
            ps.setInt(1, pUsuarios.getId_Usuarios());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    
    public ArrayList<Usuarios> MostrarUsuarios(){
        ArrayList<Usuarios> ar = new ArrayList<Usuarios>();
        try{
            ps = conectar().prepareStatement("SELECT * FROM Usuarios");
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
    /*
    
    */
    public ArrayList<Usuarios> BuscarUsuarioNombre(String texto){
        ArrayList<Usuarios> ar = new ArrayList<Usuarios>();
        try{
            String sql = "SELECT * FROM Usuarios ";
           
            ps = conectar().prepareStatement(sql);
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
    
    //buscar por id
     public Usuarios BuscarUsuarioBuscarPorId(int pId){
        
        try{
            String sql = "SELECT * FROM Usuarios  WHERE id_Usuarios=? ";
           
            ps = conectar().prepareStatement(sql);
            ps.setInt(1, pId);
            rs = ps.executeQuery();
            while(rs.next()){
                 usuario = new Usuarios(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(1));
               
            }
            ps.close();
            rs.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return usuario;
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
    public ArrayList<Usuarios> ValidarRol(String nombre){
        ArrayList<Usuarios> ar = new ArrayList<Usuarios>();
        try{
            String sql = "SELECT * FROM Usuarios WHERE nombre=?;";
           
            ps = conectar().prepareStatement(sql);
            ps.setString(1, nombre);
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
    /*
    
    */
    public boolean ValidarUsuario(Usuarios pusuario){
        try{
            ps = conectar().prepareStatement("SELECT * FROM usuarios WHERE nombre=? "
                    + "and passwor=?");
           // ps.setInt(1, pusuario.getId_Usuarios());
            ps.setString(1, pusuario.getNombre());
            ps.setString(2, pusuario.getPasswor());
            rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        }catch(Exception ex){
            
        }
        return false;
    }
}
