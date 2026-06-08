/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.arreglodeobjectos;

/**
 *
 * @author HP
 */
public class Persona {
    //Atributos
    private String nombre;
    private String apellido;
    private int cedula;

    //Constructores
    public Persona() {
    }

    public Persona(String nombre, String apellido, int cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }
    
  public void imprimir (){
      
      System.out.println("Nombre:"+nombre);
      System.out.println("Apellido:"+apellido);
      System.out.println("Cedula:"+cedula);
  }
    //Medodos setter y getters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    

   
  
}
