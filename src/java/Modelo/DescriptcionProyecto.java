/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author chris
 */
public class DescriptcionProyecto {
    /*
    CREATE TABLE `DescripcionProyecto` (
  `Id_Descripcion` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `Enunciado` Varchar(400),
  `objetivo` varchar(250),
  `ResultadosEsperados` varchar(400)
);
    */
 private int Id_Descripcion;
 private String Enunciado;
 private String objetivo;
 private String ResultadoEsperados;

    public DescriptcionProyecto() {
    }

    public DescriptcionProyecto(int Id_Descripcion, String Enunciado, String objetivo, String ResultadoEsperados) {
        this.Id_Descripcion = Id_Descripcion;
        this.Enunciado = Enunciado;
        this.objetivo = objetivo;
        this.ResultadoEsperados = ResultadoEsperados;
    }
 //setter

    public void setId_Descripcion(int Id_Descripcion) {
        this.Id_Descripcion = Id_Descripcion;
    }

    public void setEnunciado(String Enunciado) {
        this.Enunciado = Enunciado;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setResultadoEsperados(String ResultadoEsperados) {
        this.ResultadoEsperados = ResultadoEsperados;
    }
    //getter

    public int getId_Descripcion() {
        return Id_Descripcion;
    }

    public String getEnunciado() {
        return Enunciado;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getResultadoEsperados() {
        return ResultadoEsperados;
    }
    //Buscar por id
     public DescriptcionProyecto( int Id_Descripcion) {
         this.Id_Descripcion = Id_Descripcion;
         
      
    }
}
