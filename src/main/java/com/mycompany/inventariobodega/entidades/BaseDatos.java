/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariobodega.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author OSCAR
 */
@Entity
@Table(name = "basedatos")
public class BaseDatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "fknombreproducto", insertable = false, updatable = false)
    private NombreProducto nombreProducto;

    @Column(name = "fknombreproducto")
    private int fknombreproducto; // Atributo para el ID de NombreProducto

    private int stock;

    @ManyToOne
    @JoinColumn(name = "fkcategoriaproducto", insertable = false, updatable = false)
    private CategoriaProducto categoriaProducto;

    @Column(name = "fkcategoriaproducto")
    private int fkcategoriaproducto; // Atributo para el ID de CategoriaProducto

    @ManyToOne
    @JoinColumn(name = "fkubicacionproducto", insertable = false, updatable = false)
    private UbicacionProducto ubicacionProducto;

    @Column(name = "fkubicacionproducto")
    private int fkubicacionproducto; // Atributo para el ID de UbicacionProducto

    @ManyToOne
    @JoinColumn(name = "fkmarcaproducto", insertable = false, updatable = false)
    private MarcaProducto marcaProducto;

    @Column(name = "fkmarcaproducto")
    private int fkmarcaproducto; // Atributo para el ID de MarcaProducto

    @ManyToOne
    @JoinColumn(name = "fkmedidaproducto", insertable = false, updatable = false)
    private MedidaProducto medidaProducto;

    @Column(name = "fkmedidaproducto")
    private int fkmedidaproducto; // Atributo para el ID de MedidaProducto

    @ManyToOne
    @JoinColumn(name = "fkproveedorproducto", insertable = false, updatable = false)
    private ProveedorProducto proveedorProducto;

    @Column(name = "fkproveedorproducto")
    private int fkproveedorproducto; // Atributo para el ID de ProveedorProducto

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NombreProducto getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(NombreProducto nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getFknombreproducto() {
        return fknombreproducto;
    }

    public void setFknombreproducto(int fknombreproducto) {
        this.fknombreproducto = fknombreproducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public int getFkcategoriaproducto() {
        return fkcategoriaproducto;
    }

    public void setFkcategoriaproducto(int fkcategoriaproducto) {
        this.fkcategoriaproducto = fkcategoriaproducto;
    }

    public UbicacionProducto getUbicacionProducto() {
        return ubicacionProducto;
    }

    public void setUbicacionProducto(UbicacionProducto ubicacionProducto) {
        this.ubicacionProducto = ubicacionProducto;
    }

    public int getFkubicacionproducto() {
        return fkubicacionproducto;
    }

    public void setFkubicacionproducto(int fkubicacionproducto) {
        this.fkubicacionproducto = fkubicacionproducto;
    }

    public MarcaProducto getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(MarcaProducto marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public int getFkmarcaproducto() {
        return fkmarcaproducto;
    }

    public void setFkmarcaproducto(int fkmarcaproducto) {
        this.fkmarcaproducto = fkmarcaproducto;
    }

    public MedidaProducto getMedidaProducto() {
        return medidaProducto;
    }

    public void setMedidaProducto(MedidaProducto medidaProducto) {
        this.medidaProducto = medidaProducto;
    }

    public int getFkmedidaproducto() {
        return fkmedidaproducto;
    }

    public void setFkmedidaproducto(int fkmedidaproducto) {
        this.fkmedidaproducto = fkmedidaproducto;
    }

    public ProveedorProducto getProveedorProducto() {
        return proveedorProducto;
    }

    public void setProveedorProducto(ProveedorProducto proveedorProducto) {
        this.proveedorProducto = proveedorProducto;
    }

    public int getFkproveedorproducto() {
        return fkproveedorproducto;
    }

    public void setFkproveedorproducto(int fkproveedorproducto) {
        this.fkproveedorproducto = fkproveedorproducto;
    }
}
