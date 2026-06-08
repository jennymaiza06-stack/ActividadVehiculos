/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.actividadclases;

/**
 *
 * @author HP
 */
public class Persona {
    
    //Atributos
    
    public String nombre;
    public String apellido;
    public String cedula;
    public Dias diaNacimiento;
    
    public Persona () {
        
    }
            
    public Persona (String nombre,String apellido, int cedula ){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        
                        
    }
    
    public Persona (String nombre)
    
    
    public void imprimir(){
    
        System.out.println("Nombre:" + nombre);
        System.out.println("Apellido:" + apellido);
        System.out.println("Cedula:" + cedula);
        
    }
    
    public String mostrar(){
        String datos = " " + nombre +";" + apellido + ";" + cedula + ";" + diaNacimiento;
    return datos;
    }
    
    //Medoto
    
    public void imprimirNombre (Persona persona, int edad ){
        
        System.out.println("Hola soy"+ nombre +"y conozco a " + persona.nombre +" "+persona.apellido);
        
    }
    
    public
    }

            

