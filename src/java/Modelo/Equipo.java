/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author chris
 */
public class Equipo {
    /*
    CREATE TABLE `equipos` (
  `id_equipo` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_equipo` varchar(100) NOT NULL,
  `id_proyecto` int,
  `id_empleado` int
);
    */
  private int id_equipo;
  private String nombre_equipo;

    public Equipo() {
    }
    
    public Equipo(int id_equipo, String nombre_equipo) {
        this.id_equipo = id_equipo;
        this.nombre_equipo = nombre_equipo;
    }
      //Buscar por id
     public Equipo( int id_equipo) {
         this.id_equipo = id_equipo;
         
      
    }
  //setter

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

   //ggeter

    public int getId_equipo() {
        return id_equipo;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }
    
    
}
