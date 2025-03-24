/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariobodega.DAO;

import com.mycompany.inventariobodega.entidades.BaseDatos;
import com.mycompany.inventariobodega.entidades.NombreProducto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author OSCAR
 */
public class BaseDatosDao {
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public BaseDatosDao() {

        emf = Persistence.createEntityManagerFactory("MiUnidadDePersistencia");
        em = emf.createEntityManager();
    }
    
    public void guardar (BaseDatos baseDatos){
        em.getTransaction().begin();
        em.persist(baseDatos);
        em.getTransaction().commit();
    
    }
    
}
