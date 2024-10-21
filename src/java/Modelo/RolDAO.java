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
public class RolDAO {
    /*
    
    */
    PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Rol rol;
    
    Connection conectar() throws SQLException, ClassNotFoundException{
        Class.forName(con.getDriver());
        return DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
    }
    
    public int InsertarUsuarios(Rol pRol){
        int n = 0;
        try{
            ps = conectar().prepareStatement("INSERT INTO roles(nombre_rol,id_Permiso) VALUES(?,?)");
            ps.setString(1, pRol.getNombre_rol());
             ps.setInt(2, pRol.getId_Permiso());
            
              
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    
    public int ModificarRol(Rol pRol){
        int n = 0;
        try{
            ps = conectar().prepareStatement("UPDATE roles SET nombre_rol=?, id_Permiso=? WHERE id_rol=?");
              ps.setString(1, pRol.getNombre_rol());
               ps.setInt(4, pRol.getId_Permiso());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    
    public int EliminarRol(Rol pRol){
        int n = 0;
        try{
            ps = conectar().prepareStatement("DELETE FROM roles WHERE id_rol=?");
            ps.setInt(1, pRol.getId_Permiso());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    
    public ArrayList<Rol> MostrarRol(){
        ArrayList<Rol> ar = new ArrayList<Rol>();
        try{
            ps = conectar().prepareStatement("SELECT * FROM roles");
            rs = ps.executeQuery();
            while(rs.next()){
                rol = new Rol(rs.getInt(1), rs.getString(2),rs.getInt(3));
                ar.add(rol);
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
