/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariobodega.DAO;


import com.mycompany.inventariobodega.entidades.NombreProducto;
import com.mycompany.inventariobodega.entidades.VencimientoProducto;
import com.mycompany.inventariobodega.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author OSCAR
 */
public class VencimientoProductoDao {
    
    public List<NombreProducto> obtenerTodos() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT n FROM NombreProducto n", NombreProducto.class).getResultList();
        } finally {
            em.close();
        }
    }
    public void guardar(VencimientoProducto venciminetoProducto) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(venciminetoProducto);
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
     public VencimientoProducto obtenerPorFechaVencimiento(Date fechaVencimiento) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT v FROM VencimientoProducto v WHERE v.fechaVencimiento = :fechaVencimiento", VencimientoProducto.class)
                    .setParameter("fechaVencimiento", fechaVencimiento)
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
