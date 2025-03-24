/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariobodega.DAO;

import com.mycompany.inventariobodega.entidades.NombreProducto;
import com.mycompany.inventariobodega.entidades.VencimientoProducto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author OSCAR
 */
public class VencimientoProductoDao {
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public VencimientoProductoDao() {

        emf = Persistence.createEntityManagerFactory("MiUnidadDePersistencia");
        em = emf.createEntityManager();
    }
    
    public void guardar (VencimientoProducto vencimientoProducto){
        em.getTransaction().begin();
        em.persist(vencimientoProducto);
        em.getTransaction().commit();
    
    }
}
