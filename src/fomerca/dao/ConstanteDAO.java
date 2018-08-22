/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.dao;

import dto.Constante;
import java.util.List;

/**
 *
 * @author Adonis
 */
public interface ConstanteDAO extends GenericDAO<Constante> {

    public List<Constante> getConstantes();

    public Constante getConstante(String key);
}
