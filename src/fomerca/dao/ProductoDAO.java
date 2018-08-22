/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.dao;

import dto.Producto;
import java.util.List;

/**
 *
 * @author Adonis
 */
public interface ProductoDAO extends GenericDAO<Producto> {

    public List<Producto> getProductos();

    public Producto getProducto(int index);

    public Producto getProducto(String descripcion);

    public List<Producto> getProductos(String busqueda);

}
