/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espoch.actividadclases;

/**
 *
 * @author HP
 */
public class ActividadClases {

    public static void main(String[] args) {
        
        Persona personaUno = new Persona ();
        //Atributos
        personaUno.nombre = "Jenny";
        personaUno.apellido = "Maiza";
        personaUno.cedula = "22004881182";
        personaUno.diaNacimiento = Dias.MIERCOLES;
        
        Persona personaDos = new Persona ("Alexandro", "llori",2208543328);
        
                
        Persona personaDos = new Persona ();
        personaDos.nombre = "Alexandro";
        personaDos.apellido = "Llori";
        personaDos.cedula = "2208543328";
        personaDos.diaNacimiento = Dias.LUNES;
        
        Persona personaTres = new Persona ();
        personaTres.nombre = "Ana";
        personaTres.apellido = "Maiza";
        personaTres.cedula = "2234567892";
        personaTres.diaNacimiento = Dias.SABADO;
        
        System.out.println("Datos de la persona Uno");
        personaUno.imprimir();
        System.out.println("Datos de la persona Dos");
        personaDos.imprimir();
        System.out.println("Datos de la persona Tres");
        personaTres.imprimir();
        
        String contenidoMostrar=personaUno.mostrar();
        System.out.println(contenidoMostrar);
        
        String contenidoMostrarDos=personaDos.mostrar();
        System.out.println(contenidoMostrarDos);
        
        String contenidoMostrarTres=personaTres.mostrar();
        System.out.println(contenidoMostrarTres);
        
        personaDos.imprimirNombre();
   
        
        personaDos.imprimirNombre(personaUno, int edad);
        
        
    }
    
}
