/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dto.Usuario;

/**
 *
 * @author root
 */
public class SessionSettings {

    public static Usuario user;

    public static Usuario getUser() {
        return user;
    }

    public static void setUser(Usuario user) {
        SessionSettings.user = user;
    }

}
