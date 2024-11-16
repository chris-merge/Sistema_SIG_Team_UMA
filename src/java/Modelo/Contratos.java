/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author chris
 */
public class Contratos {
    /*
    CREATE TABLE `contratos` (
  `id_contrato` int PRIMARY KEY AUTO_INCREMENT,
  `nombre_contrato` varchar(100) NOT NULL,
  `presupuesto` int,
  `estado_actual` varchar(25) DEFAULT 'activo',
  `fecha_inicio` date NOT NULL,
  `fin_creacion` date NOT NULL,
  `id_proyecto` int
);

    */
    private int id_contrato;
    private String nombre_contrato;
    private float presupuesto;
    private String estado_actual;
    private String  fecha_inicio;
    private String fecha_finalizacion;
    private int id_proyecto;

    public Contratos() {
    }
//Buscar por id
     public Contratos( int id_contrato) {
         this.id_contrato = id_contrato;
         
      
    }
    public Contratos(int id_contrato, String nombre_contrato, float presupuesto, String estado_actual, String fecha_inicio, String fecha_finalizacion, int id_proyecto) {
        this.id_contrato = id_contrato;
        this.nombre_contrato = nombre_contrato;
        this.presupuesto = presupuesto;
        this.estado_actual = estado_actual;
        this.fecha_inicio = fecha_inicio;
        this.fecha_finalizacion = fecha_finalizacion;
        this.id_proyecto = id_proyecto;
    }
    //setter

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public void setNombre_contrato(String nombre_contrato) {
        this.nombre_contrato = nombre_contrato;
    }

    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    public void setEstado_actual(String estado_actual) {
        this.estado_actual = estado_actual;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_finalizacion(String fecha_finalizacion) {
        this.fecha_finalizacion = fecha_finalizacion;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }
    //getter

    public int getId_contrato() {
        return id_contrato;
    }

    public String getNombre_contrato() {
        return nombre_contrato;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public String getEstado_actual() {
        return estado_actual;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public String getFecha_finalizacion() {
        return fecha_finalizacion;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }
    
}
