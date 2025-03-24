/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariobodega.entidades;

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
    @JoinColumn(name = "fknombreproducto")
    private NombreProducto nombreProducto;
    private int stock;
    @ManyToOne
    @JoinColumn(name = "fkcategoriaproducto")
    private CategoriaProducto categoriaProducto;
    @ManyToOne
    @JoinColumn(name = "fkubicacionproducto")
    private UbicacionProducto ubicacionProducto;
    @ManyToOne
    @JoinColumn(name = "fkmarcaproducto")
    private MarcaProducto marcaProducto;
    @ManyToOne
    @JoinColumn(name = "fkvencimientoproducto")
    private VencimientoProducto vencimientoProducto;
    @ManyToOne
    @JoinColumn(name = "fkmedidaproducto")
    private MedidaProducto medidaProducto;
    @ManyToOne
    @JoinColumn(name = "fkproveedorproducto")
    private ProveedorProducto proveedorProducto;

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public NombreProducto getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(NombreProducto nombreProducto) { this.nombreProducto = nombreProducto; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public CategoriaProducto getCategoriaProducto() { return categoriaProducto; }
    public void setCategoriaProducto(CategoriaProducto categoriaProducto) { this.categoriaProducto = categoriaProducto; }
    public UbicacionProducto getUbicacionProducto() { return ubicacionProducto; }
    public void setUbicacionProducto(UbicacionProducto ubicacionProducto) { this.ubicacionProducto = ubicacionProducto; }
    public MarcaProducto getMarcaProducto() { return marcaProducto; }
    public void setMarcaProducto(MarcaProducto marcaProducto) { this.marcaProducto = marcaProducto; }
    public VencimientoProducto getVencimientoProducto() { return vencimientoProducto; }
    public void setVencimientoProducto(VencimientoProducto vencimientoProducto) { this.vencimientoProducto = vencimientoProducto; }
    public MedidaProducto getMedidaProducto() { return medidaProducto; }
    public void setMedidaProducto(MedidaProducto medidaProducto) { this.medidaProducto = medidaProducto; }
    public ProveedorProducto getProveedorProducto() { return proveedorProducto; }
    public void setProveedorProducto(ProveedorProducto proveedorProducto) { this.proveedorProducto = proveedorProducto; }
}   
