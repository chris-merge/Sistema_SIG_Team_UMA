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
public class PrivilegiosDAO {
    /*
    
    */
    PreparedStatement ps;
    ResultSet rs;
    Conexion con = new Conexion();
    Privilegios privilegios;
    
    Connection conectar() throws SQLException, ClassNotFoundException{
        Class.forName(con.getDriver());
        return DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPassword());
    }
    
    public int InsertarPrivilegios(Privilegios pPrivilegios){
        int n = 0;
        try{
            ps = conectar().prepareStatement("INSERT INTO Privilegios(categoria,Acceso) VALUES(?,?)");
            ps.setString(1, pPrivilegios.getCategoria());
             ps.setString(2, pPrivilegios.getAcceso());
              
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    
    public int ModificarPrivilegios(Privilegios pPrivilegios){
        int n = 0;
        try{
            ps = conectar().prepareStatement("UPDATE Privilegios SET categoria=?, Acceso=?WHERE id_privilegio=?");
              ps.setString(1, pPrivilegios.getCategoria());
             ps.setString(2, pPrivilegios.getAcceso());
               ps.setInt(4, pPrivilegios.getId_privelegio());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    
    public int EliminarPrivilegios(Privilegios pPrivilegios){
        int n = 0;
        try{
            ps = conectar().prepareStatement("DELETE FROM Usuarios WHERE id_Usuarios=?");
            ps.setInt(1, pPrivilegios.getId_privelegio());
            n = ps.executeUpdate();
            ps.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return n;
    }
    
    public ArrayList<Privilegios> MostrarAutores(){
        ArrayList<Privilegios> ar = new ArrayList<Privilegios>();
        try{
            ps = conectar().prepareStatement("SELECT * FROM Privilegios");
            rs = ps.executeQuery();
            while(rs.next()){
                privilegios = new Privilegios(rs.getInt(1), rs.getString(2),rs.getString(3));
                ar.add(privilegios);
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
