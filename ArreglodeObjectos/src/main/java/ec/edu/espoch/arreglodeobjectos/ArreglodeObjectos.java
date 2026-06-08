/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espoch.arreglodeobjectos;

/**
 *
 * @author HP
 */
public class ArreglodeObjectos {

    public static void main(String[] args) {
    
        Persona [] personas;
        personas = new Persona [3];
        
        personas[0]=new Persona("Jenny","Maiza",2200488);
        personas[1]=new Persona("Alex","Perez",2256789);
        personas[2]=new Persona("Maria","Perez",2227685);
        
        for (int i = 0; i < personas.length; i++) {
           System.out.println("Personas"+(i+1));
           personas[i].imprimir();
            
            
        }
   
        
      

    }
}
