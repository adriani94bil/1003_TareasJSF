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
    private static int ultimoIdTarea=0;
    private static int ultimoIdUsuario=0;

    public static ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public static int getUltimoIdTarea() {
        return ultimoIdTarea;
    }

    public static void setUltimoIdTarea(int ultimoIdTarea) {
        DB.ultimoIdTarea = ultimoIdTarea;
    }

    public static int getUltimoIdUsuario() {
        return ultimoIdUsuario;
    }

    public static void setUltimoIdUsuario(int ultimoIdUsuario) {
        DB.ultimoIdUsuario = ultimoIdUsuario;
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
        listaUsuario.add(new Usuario(++ultimoIdUsuario,"a@ruiz.es","1","adrian","ruiz"));
        listaUsuario.add(new Usuario(++ultimoIdUsuario,"ton@ton.es","1","ser","top"));
        listaUsuario.add(new Usuario(++ultimoIdUsuario,"ser@serz.es","1","ru","ghuo"));
        
        
        //Añado a cada usuario dos tareas
        listaUsuario.get(0).addTarea(new Tarea(++ultimoIdTarea, "Application JAVA", Estado.TODO, listaUsuario.get(0).getId()));
        listaUsuario.get(0).addTarea(new Tarea(++ultimoIdTarea, "Application MVC con conexion DB", Estado.TODO, listaUsuario.get(0).getId()));
        listaUsuario.get(0).addTarea(new Tarea(++ultimoIdTarea, "Leer a Escohotado", Estado.INPROGRESS, listaUsuario.get(0).getId()));
        listaUsuario.get(0).addTarea(new Tarea(++ultimoIdTarea, "Hacer la compra de navidad", Estado.INPROGRESS, listaUsuario.get(0).getId()));
        listaUsuario.get(1).addTarea(new Tarea(++ultimoIdTarea, "Levantar pesas", Estado.TODO, listaUsuario.get(1).getId()));
        listaUsuario.get(1).addTarea(new Tarea(++ultimoIdTarea, "Comer pollo y arroz", Estado.TODO, listaUsuario.get(1).getId()));
        listaUsuario.get(2).addTarea(new Tarea(++ultimoIdTarea, "Import-Export", Estado.TODO, listaUsuario.get(2).getId()));
        listaUsuario.get(2).addTarea(new Tarea(++ultimoIdTarea, "Leer el quijote", Estado.TODO, listaUsuario.get(2).getId()));
        
    }
}
