/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author chris
 */
public class Rol {
    
    /*
    CREATE TABLE `roles` (
  `id_rol` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_rol` varchar(50) NOT NULL,
  `id_Permiso` int
);
    */
 private int id_rol;
 private String nombre_rol;
 private int id_Permiso;

    public Rol() {
    }

    public Rol(int id_rol, String nombre_rol, int id_Permiso) {
        this.id_rol = id_rol;
        this.nombre_rol = nombre_rol;
        this.id_Permiso = id_Permiso;
    }

    public int getId_rol() {
        return id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public int getId_Permiso() {
        return id_Permiso;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public void setId_Permiso(int id_Permiso) {
        this.id_Permiso = id_Permiso;
    }
    

   
}
