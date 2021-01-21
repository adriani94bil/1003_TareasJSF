/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea.servicios;

import javax.ejb.Local;

/**
 *
 * @author user
 */
@Local
public interface CalculadoraSessionBeanLocal {
    public int suma(int num1,int num2);
    
    public int resta(int num1,int num2);
    
    
}
