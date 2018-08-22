/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.dao.impl;

import dto.RelFacturaProducto;
import fomerca.dao.RelFacturaProductoDAO;
import java.util.List;

/**
 *
 * @author Adonis
 */
public class RelFacturaProductoDAOImpl extends GenericDAOImpl<RelFacturaProducto> implements RelFacturaProductoDAO {

    @Override
    public void saveRelFacturaProductos(List<RelFacturaProducto> relFacturaProductos) {
        transaction = session.beginTransaction();
        for (RelFacturaProducto relFacturaProducto : relFacturaProductos) {
            session.saveOrUpdate(relFacturaProducto);
        }
        transaction.commit();
    }

}
