/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea.MB;

import com.tarea.excepcion.*;
import com.tarea.model.*;
import com.tarea.servicios.*;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "altaTareaMB")
@RequestScoped
public class AltaTareaManagedBean {

    private Tarea tarea;
    
    @EJB
    private TareasService tareaService;
    
    @Inject
    private UsuarioManagedBean usuarioMB;
    
    private Usuario usuarioLogeado;
    
    
    
    public AltaTareaManagedBean() {
        
    }
    @PostConstruct
    public void iniciar(){
        this.usuarioLogeado=usuarioMB.getUsuarioLog();
        this.tarea=new Tarea();
        tareaService.setUltimoIdTarea(tareaService.getUltimaIdTarea());
        tarea.setIdTarea(tareaService.getUltimaIdTarea());
        tarea.setEstado(Estado.TODO);
        tarea.setIdUsuario(usuarioLogeado.getId());
        
    }
    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public Usuario getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(Usuario usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }
    
    
    
    //Logger
    
    private Logger log=Logger.getLogger("AltaTareaManagedBean");
    
    //Accion
    
    public String altaTarea(){
        FacesContext ctx=FacesContext.getCurrentInstance();
        try {
            tareaService.altaTarea(tarea, tarea.getIdUsuario());
            log.info("Alta tarea OK");
            FacesMessage msg= new FacesMessage("Alta libro ok");
            ctx.addMessage(null, msg);
            return "tareas";
        } catch (DBException ex) {
            log.severe("No dio de alta la tarea. "+ex.getMessage());
            FacesMessage msg= new FacesMessage("Fallo alta libro.  "+ex.getMessage());
            ctx.addMessage(null, msg);
            return "create-tarea";
        }
    }
    
}
