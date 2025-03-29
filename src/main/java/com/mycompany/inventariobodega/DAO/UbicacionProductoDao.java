/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariobodega.DAO;


import com.mycompany.inventariobodega.entidades.UbicacionProducto;
import com.mycompany.inventariobodega.util.JPAUtil;
import jakarta.persistence.EntityManager;

/**
 *
 * @author OSCAR
 */
public class UbicacionProductoDao {

    public void guardar(UbicacionProducto ubicacionProducto) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ubicacionProducto);
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

    public UbicacionProducto obtenerPorUbicacion(String ubicacion) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT u FROM UbicacionProducto u WHERE u.ubicacion = :ubicacion", UbicacionProducto.class)
                    .setParameter("ubicacion", ubicacion)
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
