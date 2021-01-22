/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea.MB;

import com.tarea.model.Estado;
import com.tarea.model.Tarea;
import com.tarea.model.Usuario;
import com.tarea.servicios.RegisterService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

//Lo pongo como request pero al final lo logeare

@Named(value = "registroMB")
@RequestScoped
public class RegistroManagedBean {

    private Usuario user;
    
    @EJB
    private RegisterService registroService;
    
    //Injecto usuario para facilitar el login;
    @Inject
    private UsuarioManagedBean usuarioMB;
    
    
    public RegistroManagedBean() {
        
    }
    @PostConstruct
    public void iniciar(){
        this.user=new Usuario();
        user.setId(111111);
        
    }
    
}
