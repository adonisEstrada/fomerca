/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.dao.impl;

import dto.Perfil;
import dto.Usuario;
import fomerca.dao.GenericDAO;
import fomerca.dao.PerfilDAO;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Adonis
 */
public class PerfilDAOImpl extends GenericDAOImpl<Perfil> implements PerfilDAO {

    @Override
    public List<Perfil> getPerfiles() {
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Perfil perfil");
        List<Perfil> resultado = query.list();
        transaction.commit();
        return resultado;
    }

    @Override
    public Perfil getPerfil(String perfil) {
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Perfil perfil "
                + "where perfil.description=:perfil");
        query.setParameter("perfil", perfil);
        Perfil resultado = (Perfil) query.uniqueResult();
        transaction.commit();
        return resultado;
    }

}
