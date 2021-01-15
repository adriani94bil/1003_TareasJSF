/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea.MB;

import com.tarea.model.Tarea;
import com.tarea.servicios.TareasService;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author user
 */
@Named(value = "listaTareasMB")
@RequestScoped
public class ListaTareasManagedBean {

    private Collection<Tarea> listaTareas;
    private TareasService tareaServicio= new TareasService();
    private Tarea tareaSeleccionada;
    @Inject
    private UsuarioManagedBean usuarioMB;
    
    private int idUser;
    
    public ListaTareasManagedBean() {
        this.idUser=tareaServicio.getUserIdByEmail(usuarioMB.getUser());
        this.listaTareas=tareaServicio.getTareasByUser(idUser);
    }

    public Collection<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(Collection<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public TareasService getTareaServicio() {
        return tareaServicio;
    }

    public void setTareaServicio(TareasService tareaServicio) {
        this.tareaServicio = tareaServicio;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Tarea getTareaSeleccionada() {
        return tareaSeleccionada;
    }

    public void setTareaSeleccionada(Tarea tareaSeleccionada) {
        this.tareaSeleccionada = tareaSeleccionada;
    }
    
    
}
