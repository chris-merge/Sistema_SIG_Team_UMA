/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author chris
 */
public class Proyecto {
    /*
    CREATE TABLE `proyectos` (
  `id_proyecto` int PRIMARY KEY AUTO_INCREMENT,
  `Estado` varchar(25),
  `jefe_proyecto` int,
  `nombre_proyecto` varchar(100) NOT NULL,
  `descripcion` varchar(100),
  `fecha_inicio` date NOT NULL,
  `Fecha_Finalizacion` date NOT NULL,
  `id_Decripcion` int
);

    */
   private  int id_proyeto ;
   private String Estado;
   private int Jefe;
   private String nombre_proyecto;
   private String descripcion;
   private String fecha_inicio;
   private String Fecha_Finalizacion;
 

    public Proyecto() {
    }

    public Proyecto(int id_proyeto, String Estado, int Jefe, String nombre_proyecto, String descripcion, String fecha_inicio, String Fecha_Finalizacion) {
        this.id_proyeto = id_proyeto;
        this.Estado = Estado;
        this.Jefe = Jefe;
        this.nombre_proyecto = nombre_proyecto;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.Fecha_Finalizacion = Fecha_Finalizacion;
    }


public Proyecto(int id_proyeto) {
     this.id_proyeto = id_proyeto;
    }
    //seter

    public void setId_proyeto(int id_proyeto) {
        this.id_proyeto = id_proyeto;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public void setJefe(int Jefe) {
        this.Jefe = Jefe;
    }

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_Finalizacion(String Fecha_Finalizacion) {
        this.Fecha_Finalizacion = Fecha_Finalizacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
//geter

    public int getId_proyeto() {
        return id_proyeto;
    }

    public String getEstado() {
        return Estado;
    }

    public int getJefe() {
        return Jefe;
    }

    public String getNombre_proyecto() {
        return nombre_proyecto;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public String getFecha_Finalizacion() {
        return Fecha_Finalizacion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
}
