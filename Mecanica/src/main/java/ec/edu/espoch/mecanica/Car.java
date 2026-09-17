
package ec.edu.espoch.mecanica;

/**
 *
 * @author HP
 */
public class Car {
    
//Atributos
    
 public String color;
 public String brand;
 public String model;
 public boolean state;
    
         
//Metodos
 public void  started (){
     System.out.println("El carro esta encendido");
 }
 public void stopped(){
     System.out.println("El carro esta apagado ");
 }
 public void accelerate(){
     System.out.println("Acelerate");
 }
 public void brake (){
     System.out.println("Frenaste");
 
 }
    
}
