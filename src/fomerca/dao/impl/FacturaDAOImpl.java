/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.dao.impl;

import dto.Cliente;
import dto.Factura;
import fomerca.dao.FacturaDAO;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Adonis
 */
public class FacturaDAOImpl extends GenericDAOImpl<Factura> implements FacturaDAO{

    @Override
    public List<Factura> getFacturas() {
        transaction = session.beginTransaction();
        Query query = session.createQuery("select distinct factura from Factura factura "
                + "left join fetch factura.cliente cliente "
                + "left join fetch factura.relFacturaProductos rel "
                + "order by factura.fecha asc ");
        List<Factura> clientes = query.list();
        transaction.commit();
        return clientes;
    }
    
}
