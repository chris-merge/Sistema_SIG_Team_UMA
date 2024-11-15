/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author chris
 */
public class Usuarios {
    private int id_Usuarios ;
    private String nombre;
    private String email;
    private String Passwor;
    private int id_rol;
//uso del count 
    
    public Usuarios() {
    }

    public Usuarios(int id_Usuarios, String nombre, String email, String Passwor, int id_rol) {
        this.id_Usuarios = id_Usuarios;
        this.nombre = nombre;
        this.email = email;
        this.Passwor = Passwor;
        this.id_rol = id_rol;
    }

    public void setId_Usuarios(int id_Usuarios) {
        this.id_Usuarios = id_Usuarios;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswor(String Passwor) {
        this.Passwor = Passwor;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_Usuarios() {
        return id_Usuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswor() {
        return Passwor;
    }

    public int getId_rol() {
        return id_rol;
    }
    public Usuarios( String nombre, String Passwor) {
        this.nombre = nombre;
        this.Passwor = Passwor;
      
    }
    
    //Buscar por id
     public Usuarios( int id_Usuarios) {
         this.id_Usuarios = id_Usuarios;
         
      
    }

}
