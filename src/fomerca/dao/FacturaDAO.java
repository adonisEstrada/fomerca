/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.dao;

import dto.Factura;
import java.util.List;

/**
 *
 * @author Adonis
 */
public interface FacturaDAO extends GenericDAO<Factura>{
    
    public List<Factura> getFacturas();
    
}
