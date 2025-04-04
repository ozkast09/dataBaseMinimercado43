/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariobodega.DAO;

import com.mycompany.inventariobodega.entidades.BaseDatos;
import com.mycompany.inventariobodega.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OSCAR
 */
public class BaseDatosDao {
     private static final Logger LOGGER = Logger.getLogger(BaseDatosDao.class.getName());
     
     

     //Este método se utiliza cuando quieres crear un nuevo registro en la tabla de la base de datos que corresponde a la entidad BaseDatos
    public void guardar(BaseDatos baseDatos) throws PersistenceException {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(baseDatos);
            transaction.commit();
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            LOGGER.log(Level.SEVERE, "Error al guardar BaseDatos", e);
            throw e; // Re-lanzar la excepción para que el llamador pueda manejarla
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    //tiene la función principal de buscar y recuperar una única instancia de la entidad BaseDatos de la base de datos
    public BaseDatos obtenerPorNombre(int id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT b FROM BaseDatos b WHERE b.fknombreproducto = :id", BaseDatos.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Retorna null si no se encuentra el registro
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

     /*El método actualizar(BaseDatos existente) 
     tiene la función principal de modificar un registro existente de la entidad BaseDatos en la base de datos */
    public void actualizar(BaseDatos existente) throws PersistenceException {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(existente);
            transaction.commit();
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            LOGGER.log(Level.SEVERE, "Error al actualizar BaseDatos", e);
            throw e; // Re-lanzar la excepción para que el llamador pueda manejarla
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
    
   
    /*tiene la función principal de recuperar y 
    devolver una lista que contiene todas las instancias de la entidad BaseDatos que existen actualmente en la base de datos.*/
    public List<BaseDatos> obtenerTodos() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT n FROM BaseDatos n", BaseDatos.class).getResultList();
        } finally {
            em.close();
        }
    }
}

    
    

