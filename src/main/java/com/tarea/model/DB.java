/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea.model;

import com.tarea.excepcion.DBException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author user
 */
public class DB {
    private static ArrayList<Usuario> listaUsuario;

    public static ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }
    
    
    //*********************************************************
    
    //Get user del listado de usuarios por su id
    
    public static synchronized Usuario getUser(int id){
        Usuario user=null;
        for (Usuario u:listaUsuario) {
            if (u.getId()==id) {
                user=u;
            }
        }
        return user;
    }
    //Get all Tareas un usuario
    public  static synchronized Collection<Tarea> getListaTareaUser(int id){
        Collection<Tarea> listaTareas=null;
        for (Usuario u:listaUsuario) {
            if (u.getId()==id) {
                listaTareas=u.getListaTareas();
            }
        }
        
        return listaTareas;
    }
    //Añadir Usuario
    public static synchronized void addUsuario (Usuario u) throws DBException{
        listaUsuario.add(u);
    }
    //Añadir Tarea
    public static synchronized void addTarea (Tarea t, int idUser) throws DBException{
        Usuario user=DB.getUser(idUser);
        user.addTarea(t);
    }
    //Modificar tarea
    public static synchronized void setEstadoTarea(int idUsuario,int idTarea, Estado est){
        Collection<Tarea> listaTareas= DB.getListaTareaUser(idUsuario);
        for (Tarea t:listaTareas) {
            if (t.getIdTarea()==idTarea) {
                t.setEstado(est);
            }
        }
        
    }
    
    static{
        listaUsuario=new ArrayList<Usuario>();
        listaUsuario.add(new Usuario(1,"a@ruiz.es","1","adrian","ruiz"));
        listaUsuario.add(new Usuario(2,"ton@ton.es","1","ser","top"));
        listaUsuario.add(new Usuario(3,"ser@serz.es","1","ru","ghuo"));
        
        //Añado a cada usuario dos tareas
        listaUsuario.get(0).addTarea(new Tarea(1, "Application JAVA", Estado.TODO, listaUsuario.get(0).getId()));
        listaUsuario.get(0).addTarea(new Tarea(2, "Application MVC con conexion DB", Estado.TODO, listaUsuario.get(0).getId()));
        listaUsuario.get(0).addTarea(new Tarea(3, "Leer a Escohotado", Estado.INPROGRESS, listaUsuario.get(0).getId()));
        listaUsuario.get(0).addTarea(new Tarea(4, "Hacer la compra de navidad", Estado.INPROGRESS, listaUsuario.get(0).getId()));
        listaUsuario.get(1).addTarea(new Tarea(5, "Levantar pesas", Estado.TODO, listaUsuario.get(1).getId()));
        listaUsuario.get(1).addTarea(new Tarea(6, "Comer pollo y arroz", Estado.TODO, listaUsuario.get(1).getId()));
        listaUsuario.get(2).addTarea(new Tarea(7, "Import-Export", Estado.TODO, listaUsuario.get(2).getId()));
        listaUsuario.get(2).addTarea(new Tarea(8, "Leer el quijote", Estado.TODO, listaUsuario.get(2).getId()));
        
    }
}
