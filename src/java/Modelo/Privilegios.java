/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author chris
 */
public class Privilegios {
    /*
    CREATE TABLE `Privilegios` (
  `id_privilegio` int PRIMARY KEY AUTO_INCREMENT,
  `categoria` varchar(50),
  `Acceso` varchar(150)
);
    */
    private int id_privelegio;
    private String categoria;
    private String Acceso;

    public Privilegios() {
    }

    public Privilegios(int id_privelegio, String categoria, String Acceso) {
        this.id_privelegio = id_privelegio;
        this.categoria = categoria;
        this.Acceso = Acceso;
    }

    public int getId_privelegio() {
        return id_privelegio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getAcceso() {
        return Acceso;
    }

    public void setId_privelegio(int id_privelegio) {
        this.id_privelegio = id_privelegio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setAcceso(String Acceso) {
        this.Acceso = Acceso;
    }
    
}
