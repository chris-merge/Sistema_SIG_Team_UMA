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
    /*
    
    */
}
