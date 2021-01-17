/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea.MB;

import com.tarea.model.Tarea;
import com.tarea.model.Usuario;
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
    
    private Usuario usuarioLogeado;
    
    public ListaTareasManagedBean() {
        this.usuarioLogeado=usuarioMB.getUsuarioKeep();
        this.listaTareas=tareaServicio.getTareasByUser(usuarioLogeado.getId());
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

    public Usuario getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }
    

    public Tarea getTareaSeleccionada() {
        return tareaSeleccionada;
    }

    public void setTareaSeleccionada(Tarea tareaSeleccionada) {
        this.tareaSeleccionada = tareaSeleccionada;
    }
    
    
}
