/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.dao.impl;

import dto.Producto;
import dto.Usuario;
import fomerca.dao.ProductoDAO;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Adonis
 */
public class ProductoDAOImpl extends GenericDAOImpl<Producto> implements ProductoDAO {

    @Override
    public List<Producto> getProductos() {
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Producto producto "
                + "where producto.activo=true "
                + "order by producto.productoId asc");
        List<Producto> resultado = query.list();
        transaction.commit();
        return resultado;
    }

    @Override
    public Producto getProducto(int index) {
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Producto producto "
                + "where producto.productoId=:index");
        query.setParameter("index", index);
        Producto resultado = (Producto) query.uniqueResult();
        transaction.commit();
        return resultado;
    }

    @Override
    public Producto getProducto(String descripcion) {
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Producto producto "
                + "where producto.descripcion=:descripcion");
        query.setParameter("descripcion", descripcion);
        Producto resultado = (Producto) query.uniqueResult();
        transaction.commit();
        return resultado;
    }

    @Override
    public List<Producto> getProductos(String busqueda) {
        String consulta = "%" + busqueda + "%";
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Producto producto "
                + "where producto.activo=true "
                + "and (lower(producto.descripcion) like lower(:busqueda) "
                + "or lower(producto.marca) like lower(:busqueda) "
                + "or lower(producto.codigo) like lower(:busqueda) "
                + "or lower(producto.modelo) like lower(:busqueda)) "
                + "order by producto.descripcion asc");
        query.setParameter("busqueda", consulta);
        List<Producto> resultado = query.list();
        transaction.commit();
        return resultado;
    }

}
