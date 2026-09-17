

package ec.edu.espoch.mecanica;

/**
 *
 * @author HP
 */
public class Mecanica {

    public static void main(String[] args) {
        
    // Crear un objeto 
    int numero=10;
    
    Car carOne=new Car();
    carOne.started();
    
  
    
    Car carTwo=new Car();
    carTwo.started();
    
    
    Person personOne = new Person ();
    personOne.name="Jenny Maiza";
    personOne.drive(true);
       
    Person personTwo = new Person ();
    personTwo.name="Alejandro LLori";
    personTwo.drive(true);
    
    
    Person personThree = new Person ();
    personThree.name="Galo Villamar";
    personThree.drive(true);
    
    
    }
}
