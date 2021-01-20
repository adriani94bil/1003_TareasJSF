/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea.servicios;

import com.tarea.excepcion.DBException;
import com.tarea.model.*;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

//EJB DE SESION SIN ESTADO
@Stateless
public class TareasService {
    public TareasService(){
        
    }
    @PostConstruct
    public void iniciar(){
        
    }
    
    public void altaTarea(Tarea tarea,int idUser) throws DBException{
        DB.addTarea(tarea, idUser);
    }
    public Collection<Usuario> getAllUsers(){
        return DB.getListaUsuario();
    }
    public Collection<Tarea> getTareasByUser(int id){
        return DB.getListaTareaUser(id);
    }
    public Collection<Tarea> getTareasByUserToDo(Collection<Tarea> listaTareas){
        Collection<Tarea> listaTareasEst=new ArrayList<Tarea>();
        for (Tarea t:listaTareas){
            if (t.getEstado()==Estado.TODO) {
                listaTareasEst.add(t);
            }
        }
        return listaTareasEst;
    }
    public Collection<Tarea> getTareasByUserInProgress(Collection<Tarea> listaTareas){
        Collection<Tarea> listaTareasEst=new ArrayList<Tarea>();
        for (Tarea t:listaTareas){
            if (t.getEstado()==Estado.INPROGRESS) {
                listaTareasEst.add(t);
            }
        }
        return listaTareasEst;
    }
    public Collection<Tarea> getTareasByUserDone(Collection<Tarea> listaTareas){
        Collection<Tarea> listaTareasEst=new ArrayList<Tarea>();
        for (Tarea t:listaTareas){
            if (t.getEstado()==Estado.DONE) {
                listaTareasEst.add(t);
            }
        }
        return listaTareasEst;
    }
    public void setEstadoTarea (int idUsuario,int idTarea, Estado est) throws DBException{
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
    
    public int getUltimaIdTarea(){
        return DB.getUltimoIdTarea();
    }
    public int getUltimaIdUsuario(){
        return DB.getUltimoIdUsuario();
    }
    public void setUltimoIdTarea(int newId){
        DB.setUltimoIdTarea(++newId);
    }
    public void setUltimoIdUsuario(int newId){
        DB.setUltimoIdUsuario(++newId);
    }
}
