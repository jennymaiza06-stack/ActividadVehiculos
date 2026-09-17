
package ec.edu.espoch.primerproyectojava;

import java.util.Scanner;

public class PrimerProyectoJava {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    /*   
    // Variable
    var uno=0.0;
    int edad=25;
    String nombre="Jenny";
    float estatura= 1.55F;
    boolean estudiante= true;       
    char inicial= 'J';
    
    byte num=125;
    short numUno=32767;
    long numDos=4546545456L;
    int numTres=454;
    float numCuatro=45.000F;
    double numCinco=45.0000;
    String nombres= "Jenny Maiza";
    char letra= 'J';
    
            
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Float.MAX_VALUE);
    
    //castear
    String cantidad="10";
    int cantidadDos=2;
    int resultado=cantidadDos+Integer.parseInt(cantidad);
    System.out.println("Resultado"+resultado);
    */
            
    
    
    
    /*
    
    String name ="Jenny Maiza";
    byte edad=20;
    
    if(edad>=0&& edad <=120){
      if(edad>0&& edad <=1){
        
    System.out.println(name+ "es un bebe");
        
    }else if(edad>1 && edad <12){
        System.out.println(name+ "es un niño");   
        
    }else if(edad>12&& edad <18){
        System.out.println(name+ "es un adolecente");
        
    }else if(edad>18){
        System.out.println(name+ "es un adulto");
    }
  
    }else{
        System.out.println("Fuera de rango");
    }
    */
    
    
    
    /*     
    Scanner e= new Scanner (System.in);
        System.out.println("1. Suma");
        System.out.println("2.Resta");
        System.out.println("3.Multiplicacion");
        System.out.println("4.Division");
    
        System.out.println("Ingrese una opcion (1-4):");
        int operacion = e.nextInt();
        System.out.println("Ingrese el primer numero:");
            int numUno= e.nextInt();
            System.out.println("Ingrese el segundo numero:");
            int numDos=e.nextInt();
            
            switch (operacion) {
            case 1:
                System.out.println("Resultado:"+(numUno+numDos));
                break;
            case 2:
                System.out.println("Resultado:"+(numUno - numDos));
                break;
            
            case 3:
                System.out.println("Resultado:"+(numUno * numDos));
                break;
            case 4:
                System.out.println("Resultado:"+(numUno / numDos));
                break; 
            default:
                throw new AssertionError();
        }
      
   */
      
    /*
      //REPETITIVAS
      Scanner e= new Scanner (System.in);
      System.out.println("Intrege el valor de la tabla a generar:");
      int tableM = e.nextInt();
        for (int i = 1; i <=10; i++) {
            System.out.println(tableM + "X"+ i +"="+(tableM *i));
            
        }
        
        /*
        
        
        
        */
    
    
    int contador=1;
    while(contador <=10){
    System.out.println(tableM +"X"+contador + (tableM * contador));
    contador=contador+1;
}
    
    }