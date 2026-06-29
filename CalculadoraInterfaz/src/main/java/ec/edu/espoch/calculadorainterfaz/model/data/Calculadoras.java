/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.calculadorainterfaz.model.data;

import ec.edu.espoch.calculadorainterfaz.model.access.InterCalculadora;
import ec.edu.espoch.calculadorainterfaz.model.object.Calculadora;

/**
 *
 * @author HP
 */
public class Calculadoras implements InterCalculadora {

   
    public double sumar(Calculadora calculadora ){
        
        return calculadora.getNumeroUno()+ calculadora.getNumeroDos();
    }
    
}

