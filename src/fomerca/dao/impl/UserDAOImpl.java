/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.dao.impl;

import dto.Usuario;
import fomerca.dao.GenericDAO;
import fomerca.dao.UserDAO;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Adonis
 */
public class UserDAOImpl extends GenericDAOImpl<Usuario> implements UserDAO {

    @Override
    public Usuario getUser(String name, String pass) {
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Usuario user "
                + "inner join fetch user.perfil perfil "
                + "where user.name=:name and user.pass=:pass "
                + "and user.activo=true");
        query.setParameter("name", name);
        query.setParameter("pass", pass);
        Usuario user = (Usuario) query.uniqueResult();
        transaction.commit();
        return user;
    }

    @Override
    public List<Usuario> getUsers() {
        transaction = session.beginTransaction();
        Query query = session.createQuery("select distinct user from Usuario user "
                + "left join fetch user.perfil perfil "
                + "where user.activo=true");
        List<Usuario> resultado = query.list();
        transaction.commit();
        return resultado;
    }

    @Override
    public Usuario getUser(String name) {
        transaction = session.beginTransaction();
        Query query = session.createQuery("select distinct user from Usuario user "
                + "inner join fetch user.perfil perfil "
                + "where user.name=:name and user.activo=true");
        query.setParameter("name", name);
        Usuario user = (Usuario) query.uniqueResult();
        transaction.commit();
        return user;
    }
}
