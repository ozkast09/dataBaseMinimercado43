/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariobodega.DAO;


import com.mycompany.inventariobodega.entidades.MarcaProducto;
import com.mycompany.inventariobodega.util.JPAUtil;
import jakarta.persistence.EntityManager;

/**
 *
 * @author OSCAR
 */
public class MarcaProductoDao {
     public void guardar(MarcaProducto marcaProducto) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(marcaProducto);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
     public MarcaProducto obtenerPorMarca(String marca) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT m FROM MarcaProducto m WHERE m.marca = :marca", MarcaProducto.class)
                    .setParameter("marca", marca)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
    
}
