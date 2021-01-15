/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea.model;

import java.io.Serializable;
import java.util.Objects;


public class Tarea implements Serializable {
    private int idTarea;
    private String Descripcion;
    private Estado estado;
    private int idUsuario;

    public Tarea(int idTarea, String Descripcion, Estado estado,int idUsuario) {
        this.idTarea = idTarea;
        this.Descripcion = Descripcion;
        this.estado = estado;
        this.idUsuario=idUsuario;
    }

    public Tarea(int idTarea, String Descripcion, int idUsuario) {
        this.idTarea = idTarea;
        this.Descripcion = Descripcion;
        this.estado=estado.TODO;
        this.idUsuario = idUsuario;
    }
    

    public Tarea() {
    }
    
    
    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idTarea;
        hash = 67 * hash + Objects.hashCode(this.Descripcion);
        hash = 67 * hash + Objects.hashCode(this.estado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarea other = (Tarea) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Tarea{" + "idTarea=" + idTarea + ", Descripcion=" + Descripcion + ", estado=" + estado + '}';
    }
}
