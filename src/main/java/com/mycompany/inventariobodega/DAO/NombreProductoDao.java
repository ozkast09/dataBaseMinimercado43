/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariobodega.DAO;

import com.mycompany.inventariobodega.entidades.NombreProducto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author OSCAR
 */
public class NombreProductoDao {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public NombreProductoDao() {

        emf = Persistence.createEntityManagerFactory("MiUnidadDePersistencia");
        em = emf.createEntityManager();
    }
    
    public void guardar (NombreProducto nombreProducto){
        em.getTransaction().begin();
        em.persist(nombreProducto);
        em.getTransaction().commit();
    
    }

}
