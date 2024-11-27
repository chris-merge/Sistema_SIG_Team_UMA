/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author chris
 */
public class tProveedores {
      private int idproveedores;
    private String nomproveedor;    
    private int telproveedor;
    private String correoproveedor;
    private tMarcas marcas;
    
public tProveedores() {
    }
    
    public tProveedores(int idproveedores, String nomproveedor, int telproveedor, String correoproveedor, tMarcas marcas) {
        this.idproveedores = idproveedores;
        this.nomproveedor = nomproveedor;
        this.telproveedor = telproveedor;
        this.correoproveedor = correoproveedor;
        this.marcas = marcas;
    }

    public int getIdproveedores() {
        return idproveedores;
    }

    public void setIdproveedores(int idproveedores) {
        this.idproveedores = idproveedores;
    }

    public String getNomproveedor() {
        return nomproveedor;
    }

    public void setNomproveedor(String nomproveedor) {
        this.nomproveedor = nomproveedor;
    }

    public tMarcas getMarcas() {
        return marcas;
    }

    public void setMarcas(tMarcas marcas) {
        this.marcas = marcas;
    }

    public int getTelproveedor() {
        return telproveedor;
    }

    public void setTelproveedor(int telproveedor) {
        this.telproveedor = telproveedor;
    }

    public String getCorreoproveedor() {
        return correoproveedor;
    }

    public void setCorreoproveedor(String correoproveedor) {
        this.correoproveedor = correoproveedor;
    }
}
