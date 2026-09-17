
package ec.edu.espoch.mecanica;

/**
 *
 * @author HP
 */
public class Person {
    
public String name;
public byte age;


public void drive (boolean state ){
    if (state == true){
        System.out.println("Puedes manejar");
    }else{
        System.out.println("Enciende el carro");
    }
    
}
public void getIn() {
    System.out.println("Ingrese al carro");
    
}
public void getOut(){
    System.out.println("");
}
}
