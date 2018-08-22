/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.dao;

import dto.Cliente;
import java.util.List;

/**
 *
 * @author Adonis
 */
public interface ClienteDAO extends GenericDAO<Cliente> {

    public List<Cliente> getClientes();

    public Cliente getCliente(int index);

    public Cliente getClienteByCedula(int cedula);

    public List<Cliente> getClientes(String busqueda);

}
