/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.stack;

/**
 *
 * @author HP
 */
public class Pila {
    
    private Nodo cima;
    private int tamaño;

    public Pila () {
        this.cima = null;
        this.tamaño = 0;
    }
    
    //Metodo para agregar un elemento a la pila (push)
        public void push (int dato){
            Nodo nuevoNodo = new Nodo (dato);
            // El nuevo nodo apunta al anterior nodo de la cima
            nuevoNodo.siguiente = cima;
            //La cima ahora es el nuevo nodo
            cima = nuevoNodo;
            tamaño++;
    }
    
    public int pop (){
        
        int  dato = cima.getDato();
        cima = cima.siguiente;
        tamaño--;
        return dato;
    }
    
    //Metodo para ver el elemento en la cima sin removerlo
    public int peek (){
        return cima.getDato();
    }
        
    public boolean isEmpty (){
        return cima == null;
    }    
    public int getTamaño(){
        return tamaño;
    }
      
    public void mostrarElementos(){
        
        //Recorrer la pila hasta llegar al final (null)
        Nodo actual = cima;
        System.out.println("Elementos en la pila ");
        while (actual!= null){
            System.out.println(actual.getDato()); //Imprimir
            actual = actual.siguiente;  // Moverse al siguiente 
        }
            
    }
            
    
    
    }
