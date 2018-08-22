/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.dao.impl;

import dto.Constante;
import fomerca.dao.ConstanteDAO;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Adonis
 */
public class ConstanteDAOImpl extends GenericDAOImpl<Constante> implements ConstanteDAO {

    @Override
    public List<Constante> getConstantes() {
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Constante constante "
                + "where constante.activo=true");
        List<Constante> resultado = query.list();
        transaction.commit();
        return resultado;
    }

    @Override
    public Constante getConstante(String key) {
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Constante constante "
                + "where constante.activo=true "
                + "and constante.key=:key");
        query.setParameter("key", key);
        Constante resultado = (Constante) query.uniqueResult();
        transaction.commit();
        return resultado;
    }

}
