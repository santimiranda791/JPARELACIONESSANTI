package com.santi.dao;

import com.santi.aplicacion.JPAUtil;
import com.santi.entidades.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
public class ProductoDao {
    EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
    public String registrarProducto(Producto miProducto) {
        String resp="";
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(miProducto);
            entityManager.getTransaction().commit();



            resp="Producto Registrado!";
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se puede registrar "
                            + "el Producto",
                    "ERROR",JOptionPane.ERROR_MESSAGE);

        }
        return resp;
    }
    public Producto consultarProducto(Long idProducto) {
        Producto miProducto=entityManager.find(Producto.class,idProducto);
        if (miProducto!=null) {
            return miProducto;
        }else {
            return null;
        }
    }
    public List<Producto> consultarListaProductos() {
        List<Producto> listaProductos=new ArrayList<Producto>();
        Query query=entityManager.createQuery("SELECT p FROM Producto p");
        listaProductos=query.getResultList();
        return listaProductos;
    }
    public String actualizarProducto(Producto miProducto) {
        String resp="";
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(miProducto);
            entityManager.getTransaction().commit();
            resp="Producto Actualizado!";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se puede actualizar "
                            + "el Producto ",
                    "ERROR",JOptionPane.ERROR_MESSAGE);

        }
        return resp;
    }
    public String eliminarProducto(Producto miProducto) {
        entityManager.getTransaction().begin();
        entityManager.remove(miProducto);
        entityManager.getTransaction().commit();
        String resp="Producto Actualizado!";
        return resp;
    }
    public void close() {
        entityManager.close();
        JPAUtil.shutdown();
    }
}
