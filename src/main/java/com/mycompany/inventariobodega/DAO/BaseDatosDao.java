/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariobodega.DAO;

import com.mycompany.inventariobodega.entidades.BaseDatos;
import com.mycompany.inventariobodega.util.JPAUtil;
import jakarta.persistence.EntityManager;

/**
 *
 * @author OSCAR
 */
public class BaseDatosDao {
     public void guardar(BaseDatos baseDatos) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(baseDatos);
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
    
}
