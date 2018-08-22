/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.dao.impl;

import dto.Cliente;
import dto.Usuario;
import fomerca.dao.ClienteDAO;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Adonis
 */
public class ClienteDAOImpl extends GenericDAOImpl<Cliente> implements ClienteDAO {

    @Override
    public List<Cliente> getClientes() {
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Cliente cliente "
                + "where cliente.activo=true");
        List<Cliente> clientes = query.list();
        transaction.commit();
        return clientes;
    }

    @Override
    public Cliente getCliente(int index) {
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Cliente cliente "
                + "where cliente.clienteId=:index "
                + "and cliente.activo=true");
        query.setParameter("index", index);
        Cliente cliente = (Cliente) query.uniqueResult();
        transaction.commit();
        return cliente;
    }

    @Override
    public Cliente getClienteByCedula(int cedula) {
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Cliente cliente "
                + "where cliente.cedula=:cedula "
                + "and cliente.activo=true");
        query.setParameter("cedula", cedula);
        Cliente cliente = (Cliente) query.uniqueResult();
        transaction.commit();
        return cliente;
    }

    @Override
    public List<Cliente> getClientes(String busqueda) {
        String consulta = "%" + busqueda + "%";
        transaction = session.beginTransaction();
        Query query = session.createQuery("from Cliente cliente "
                + "where cliente.activo=true "
                + "and ( lower(cliente.nombre) like lower(:busqueda)"
                + "or lower(cliente.apellido) like lower(:busqueda) "
                + "or cast(cliente.cedula as string) like :busqueda)");
        query.setParameter("busqueda", consulta);
        List<Cliente> clientes = query.list();
        transaction.commit();
        return clientes;
    }
}
