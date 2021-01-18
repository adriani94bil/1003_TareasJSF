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
import javax.annotation.PostConstruct;
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
    private Collection<Tarea> listaTareasToDo;
    private Collection<Tarea> listaTareasIn;
    private Collection<Tarea> listaTareasDone;
    private TareasService tareaServicio= new TareasService();
    private Tarea tareaSeleccionada;
    @Inject
    private UsuarioManagedBean usuarioMB;
    
    private Usuario usuarioLogeado;
    
    public ListaTareasManagedBean() {
        
    }
    
    //Sin el postconstruct las dependencias no van bien
    @PostConstruct
    public void iniciar(){
        this.usuarioLogeado=usuarioMB.getUsuarioLog();
        this.listaTareas=tareaServicio.getTareasByUser(usuarioLogeado.getId());
        this.listaTareasToDo=tareaServicio.getTareasByUserToDo(listaTareas);
        this.listaTareasIn=tareaServicio.getTareasByUserInProgress(listaTareas);
        this.listaTareasDone=tareaServicio.getTareasByUserDone(listaTareas);
        
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

    public Collection<Tarea> getListaTareasToDo() {
        return listaTareasToDo;
    }

    public void setListaTareasToDo(Collection<Tarea> listaTareasToDo) {
        this.listaTareasToDo = listaTareasToDo;
    }

    public Collection<Tarea> getListaTareasIn() {
        return listaTareasIn;
    }

    public void setListaTareasIn(Collection<Tarea> listaTareasIn) {
        this.listaTareasIn = listaTareasIn;
    }

    public Collection<Tarea> getListaTareasDone() {
        return listaTareasDone;
    }

    public void setListaTareasDone(Collection<Tarea> listaTareasDone) {
        this.listaTareasDone = listaTareasDone;
    }
    
    
    
    
}
