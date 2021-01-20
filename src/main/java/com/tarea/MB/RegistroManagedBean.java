/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea.MB;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

//Lo pongo como request pero al final lo logeare

@Named(value = "registroMB")
@RequestScoped
public class RegistroManagedBean {

    /**
     * Creates a new instance of RegistroManagedBean
     */
    public RegistroManagedBean() {
    }
    
}
