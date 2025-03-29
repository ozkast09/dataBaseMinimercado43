/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariobodega.DAO;


import com.mycompany.inventariobodega.entidades.CategoriaProducto;
import com.mycompany.inventariobodega.util.JPAUtil;
import jakarta.persistence.EntityManager;

/**
 *
 * @author OSCAR
 */
public class CategoriProductoDao {
     public void guardar(CategoriaProducto categoriaProducto) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(categoriaProducto);
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
     public CategoriaProducto obtenerPorCategoria(String categoria) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT c FROM CategoriaProducto c WHERE c.categoria = :categoria", CategoriaProducto.class)
                    .setParameter("categoria", categoria)
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
    

