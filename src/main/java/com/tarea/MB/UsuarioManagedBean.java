/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea.MB;

import com.tarea.excepcion.LoginException;
import com.tarea.model.Usuario;
import com.tarea.servicios.LoginService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@Named(value = "usuarioMB")
@SessionScoped
public class UsuarioManagedBean implements Serializable {
    private String email;
    private String clave;
    private Usuario usuarioLog;
    private LoginService loginService=new LoginService();
    
    
            
    /**
     * Creates a new instance of UsuarioManagedBean
     */
    public UsuarioManagedBean() {
        this.usuarioLog=new Usuario();
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUser() {
        return email;
    }

    public void setUser(String user) {
        this.email = user;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public Usuario getUsuarioLog() {
        return usuarioLog;
    }

    public void setUsuarioLog(Usuario usuarioLog) {
        this.usuarioLog = usuarioLog;
    }
    
    
    public String login(){
        FacesContext ctx=FacesContext.getCurrentInstance();
        try {            
            loginService.login(email, clave, (HttpSession) ctx.getExternalContext().getSession(true));
            usuarioLog=loginService.getUserByEmail(email);
            return "index";
        } catch (LoginException ex) {
            Logger.getLogger(UsuarioManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            this.email="";
            this.clave="";
            FacesMessage msg=new FacesMessage(ex.getMessage());
            ctx.addMessage(null, msg);
            return "login?faces-redirect=true";
        }
    }
    public String logout(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "login?faces-redirect=true";
        
    }
}
