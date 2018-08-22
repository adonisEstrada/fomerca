/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.dao;

import dto.Perfil;
import java.util.List;

/**
 *
 * @author Adonis
 */
public interface PerfilDAO extends GenericDAO<Perfil> {

    public List<Perfil> getPerfiles();

    public Perfil getPerfil(String perfil);

}
