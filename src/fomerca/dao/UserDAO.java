/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.dao;

import dto.Usuario;
import java.util.List;

/**
 *
 * @author Adonis
 */
public interface UserDAO extends GenericDAO<Usuario> {

    public Usuario getUser(String name, String pass);

    public List<Usuario> getUsers();

    public Usuario getUser(String name);

}
