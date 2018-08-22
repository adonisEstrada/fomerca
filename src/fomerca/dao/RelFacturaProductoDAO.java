/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.dao;

import dto.RelFacturaProducto;
import java.util.List;

/**
 *
 * @author Adonis
 */
public interface RelFacturaProductoDAO extends GenericDAO<RelFacturaProducto> {

    public void saveRelFacturaProductos(List<RelFacturaProducto> relFacturaProductos);
}
