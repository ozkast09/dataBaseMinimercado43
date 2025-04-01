/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariobodega.entidades;

/**
 *
 * @author OSCAR
 */

//declaracion de la clase
public class BaseDatosTabla {
    
    //declaracion de variables de instancia
     private String nombreProducto;
    private String marcaProducto;
    private String categoriaProducto;
    private String medidaProducto;
    private String ubicacionProducto;
    private String proveedorProducto;
    private int stock;

    // Constructor
    public BaseDatosTabla(String nombreProducto, String marcaProducto, String categoriaProducto, String medidaProducto, String ubicacionProducto, String proveedorProducto, int stock) {
        this.nombreProducto = nombreProducto;
        this.marcaProducto = marcaProducto;
        this.categoriaProducto = categoriaProducto;
        this.medidaProducto = medidaProducto;
        this.ubicacionProducto = ubicacionProducto;
        this.proveedorProducto = proveedorProducto;
        this.stock = stock;
    }

    // Getters y setters
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public String getMedidaProducto() {
        return medidaProducto;
    }

    public void setMedidaProducto(String medidaProducto) {
        this.medidaProducto = medidaProducto;
    }

    public String getUbicacionProducto() {
        return ubicacionProducto;
    }

    public void setUbicacionProducto(String ubicacionProducto) {
        this.ubicacionProducto = ubicacionProducto;
    }

    public String getProveedorProducto() {
        return proveedorProducto;
    }

    public void setProveedorProducto(String proveedorProducto) {
        this.proveedorProducto = proveedorProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
