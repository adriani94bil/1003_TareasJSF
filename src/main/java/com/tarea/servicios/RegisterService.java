/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea.servicios;

import com.tarea.excepcion.DBException;
import com.tarea.excepcion.LoginException;
import com.tarea.model.*;
import java.util.Collection;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class RegisterService {
    public void register(Usuario u, HttpSession session) throws LoginException, DBException{
        //Si existe email y clave
        Collection<Usuario> usuarios= DB.getListaUsuario();
        Usuario userEncontrado=null;
        
        //Buscamos Usuario
        for (Usuario user:usuarios) {
            if (user.getEmail().equals(u.getEmail())) {
                userEncontrado=u;
                break;
            }
        }
        //si existe añadir a session
        if (userEncontrado!=null) {
            throw new LoginException("El usuario ya existe, vaya a login");
        } else {
            DB.addUsuario(u);
            session.setAttribute("usuario", userEncontrado);
            
        }
    }
}
