/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariobodega.DAO;

/**
 *
 * @author OSCAR
 */
import HibernateUtil.HibernateUtil;
import com.mycompany.inventariobodega.entidades.NombreProducto;
import jakarta.persistence.EntityManager;
import com.mycompany.inventariobodega.util.JPAUtil; // Importa JPAUtil
import jakarta.transaction.SystemException;
import org.hibernate.Transaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

public class NombreProductoDao {

    public List<NombreProducto> obtenerTodos() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT n FROM NombreProducto n", NombreProducto.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void guardar(NombreProducto nombreProducto) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(nombreProducto);
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

    public NombreProducto obtenerPorNombre(String nombre) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT n FROM NombreProducto n WHERE n.nombre = :nombre", NombreProducto.class)
                    .setParameter("nombre", nombre)
                    .getResultStream()
                    .findFirst()
                    .orElse(null);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
    
    public NombreProducto obtenerPorId(int id) {
        Transaction transaction = null;
        NombreProducto nombreProducto = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = (Transaction) session.beginTransaction();
            nombreProducto = session.get(NombreProducto.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (IllegalStateException ex) {
                    Logger.getLogger(NombreProductoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            e.printStackTrace();
        }
        return nombreProducto;
    }

   
}
