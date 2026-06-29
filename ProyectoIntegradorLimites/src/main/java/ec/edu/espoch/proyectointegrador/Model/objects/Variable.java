package ec.edu.espoch.proyectointegrador.Model.objects;


public class Variable extends Expresion {
 
    private String nombre;
 
    //Constructor
    public Variable(String nombre) {
        this.nombre = nombre;
    }
 
    //Metodos
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    @Override
    public double evaluar(double x) {
       
        return x;
    }
 
    @Override
    public String identificarTipo() {
        return "Variable";
    }
 
}