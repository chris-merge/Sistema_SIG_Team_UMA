/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author chris
 */
public class Cargo {
    /*
    CREATE TABLE `cargos` (
  `id_cargo` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_cargo` varchar(100) NOT NULL
);
    */
    private int id_cargo;
    private String nombre_cargo;

    public Cargo() {
    }

    public Cargo(int id_cargo, String nombre_cargo) {
        this.id_cargo = id_cargo;
        this.nombre_cargo = nombre_cargo;
    }
    //seter

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public void setNombre_cargo(String nombre_cargo) {
        this.nombre_cargo = nombre_cargo;
    }
    //getter

    public int getId_cargo() {
        return id_cargo;
    }

    public String getNombre_cargo() {
        return nombre_cargo;
    }
     //Buscar por id
     public Cargo( int id_cargo) {
         this.id_cargo = id_cargo;
         
      
    }
}
