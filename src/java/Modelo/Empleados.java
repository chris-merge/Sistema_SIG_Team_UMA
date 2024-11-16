/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author chris
 */
public class Empleados {
    /*
    CREATE TABLE `empleados` (
  `id_persona` int PRIMARY KEY,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `id_cargo` int,
  `telefono` varchar(20),
  `direccion` varchar(100),
  `id_user` int NOT NULL
);
    */
    private int id_persona;
    private String nombre;
    private String apellido;
    private int id_cargo;
    private String telefono;
    private String direccion;
    private int id_user;

    public Empleados() {
    }

    public Empleados(int id_persona, String nombre, String apellido, int id_cargo, String telefono, String direccion, int id_user) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id_cargo = id_cargo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.id_user = id_user;
    }
    //seter

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    //getter

    public int getId_persona() {
        return id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getId_user() {
        return id_user;
    }
    //Buscar por id
     public Empleados( int id_persona) {
         this.id_persona = id_persona;
         
      
    }
}
