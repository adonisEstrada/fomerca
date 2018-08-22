/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fomerca.dao;

/**
 *
 * @author root
 */
public interface GenericDAO<T> {
    public void save(T t);
}
