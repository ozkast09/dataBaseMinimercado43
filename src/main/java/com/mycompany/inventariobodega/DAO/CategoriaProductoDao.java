/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariobodega.DAO;

import com.mycompany.inventariobodega.entidades.CategoriaProducto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author OSCAR
 */
public class CategoriaProductoDao {
    
     private final EntityManagerFactory emf;
    private final EntityManager em;

    public CategoriaProductoDao() {

        emf = Persistence.createEntityManagerFactory("MiUnidadDePersistencia");
        em = emf.createEntityManager();
    }
    
    public void guardar (CategoriaProducto categoriaProducto){
        em.getTransaction().begin();
        em.persist(categoriaProducto);
        em.getTransaction().commit();
    }
    
    
}
