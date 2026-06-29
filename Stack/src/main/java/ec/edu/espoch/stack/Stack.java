/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espoch.stack;

/**
 *
 * @author HP
 */
public class Stack {
    
    public static void main (String []args){
        
        Pila pila = new Pila();
        pila.push(4);
        pila.push(5);
        pila.push(6);
        pila.push(7);
        
        pila.mostrarElementos();
        pila.pop();
        pila.mostrarElementos();
    }
}




