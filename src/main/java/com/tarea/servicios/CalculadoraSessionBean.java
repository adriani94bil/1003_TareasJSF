/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarea.servicios;

import javax.ejb.Stateless;

/**
 *
 * @author user
 */
@Stateless
public class CalculadoraSessionBean implements CalculadoraSessionBeanLocal {

    @Override
    public int suma(int num1, int num2) {
        return (num1+num2);
    }

    @Override
    public int resta(int num1, int num2) {
        return (num1*num2);
    }

    
}
