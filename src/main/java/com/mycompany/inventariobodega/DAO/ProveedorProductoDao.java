/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariobodega.DAO;


import com.mycompany.inventariobodega.entidades.ProveedorProducto;
import com.mycompany.inventariobodega.util.JPAUtil;
import jakarta.persistence.EntityManager;

/**
 *
 * @author OSCAR
 */
public class ProveedorProductoDao {
     public void guardar(ProveedorProducto proveedorProducto) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(proveedorProducto);
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
     public ProveedorProducto obtenerPorProveedor(String proveedor) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT p FROM ProveedorProducto p WHERE p.proveedor = :proveedor", ProveedorProducto.class)
                    .setParameter("proveedor", proveedor)
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
