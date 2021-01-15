/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea.servicios;

import com.tarea.excepcion.DBException;
import com.tarea.model.*;
import java.util.Collection;

/**
 *
 * @author user
 */
public class TareasService {
    public void altaTarea(Tarea tarea,int idUser) throws DBException{
        DB.addTarea(tarea, idUser);
    }
    public Collection<Usuario> getAllUsers(){
        return DB.getListaUsuario();
    }
    public Collection<Tarea> getTareasByUser(int id){
        return DB.getListaTareaUser(id);
    }
    public void setEstadoTarea(int idUsuario,int idTarea, Estado est){
        DB.setEstadoTarea(idUsuario, idTarea, est);
    }
    public Usuario getUserById(int id){
        return DB.getUser(id);
    }
    public int getUserIdByEmail(String email){
        Collection<Usuario> usuarios= DB.getListaUsuario();
        Usuario userEncontrado=null;
        //Buscamos Usuario
        for (Usuario u:usuarios) {
            if (u.getEmail().equals(email)) {
                userEncontrado=u;
                break;
            }
        }
        return userEncontrado.getId();
    }
}
