/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author chris
 */
public class tMarcas {
     private int idmarcas;
    private String nommarcas;
    
     public tMarcas() {
    }
     
    public tMarcas(int idmarcas, String nommarcas) {
        this.idmarcas = idmarcas;
        this.nommarcas = nommarcas;
    }

    public int getIdmarcas() {
        return idmarcas;
    }

    public void setIdmarcas(int idmarcas) {
        this.idmarcas = idmarcas;
    }

    public String getNommarcas() {
        return nommarcas;
    }

    public void setNommarcas(String nommarcas) {
        this.nommarcas = nommarcas;
    }
}
