/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventariobodega.DAO;



import HibernateUtil.HibernateUtil;
import com.mycompany.inventariobodega.entidades.ProveedorProducto;
import com.mycompany.inventariobodega.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author OSCAR
 */
public class ProveedorProductoDao {
    
    /*tiene la función principal de recuperar y 
    devolver una lista que contiene todas las instancias de la entidad BaseDatos que existen actualmente en la base de datos.*/
    public List<ProveedorProducto> obtenerTodos() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT n FROM ProveedorProducto n", ProveedorProducto.class).getResultList();
        } finally {
            em.close();
        }
    }
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
    
     //tiene la función principal de buscar y recuperar una única instancia de la entidad BaseDatos de la base de datos
     public ProveedorProducto obtenerPorId(int id){
     
         Transaction transaction=null;
         ProveedorProducto categoriaProducto=null;
          try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            categoriaProducto = session.get(ProveedorProducto.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return categoriaProducto;
    }
}
