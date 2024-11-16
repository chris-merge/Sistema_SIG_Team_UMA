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
  private int id_proyecto;
  private int id_empleado;

    public Equipo() {
    }

    public Equipo(int id_equipo, String nombre_equipo, int id_proyecto, int id_empleado) {
        this.id_equipo = id_equipo;
        this.nombre_equipo = nombre_equipo;
        this.id_proyecto = id_proyecto;
        this.id_empleado = id_empleado;
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

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
    //getter

    public int getId_equipo() {
        return id_equipo;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public int getId_empleado() {
        return id_empleado;
    }
    
}
