package ec.edu.espoch.proyectointegrador.Model.objects;


public class Exponencial extends Expresion {

    //Atributos
    private double base;
    private Expresion subExpresion;

    
    //Constructor

    public Exponencial(double base, Expresion subExpresion) {
        this.base = base;
        this.subExpresion = subExpresion;
    }

    //Metodos
    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public Expresion getSubExpresion() {
        return subExpresion;
    }

    public void setSubExpresion(Expresion subExpresion) {
        this.subExpresion = subExpresion;
    }
    
    

    @Override
    public double evaluar(double x) {
        double argumento = subExpresion.evaluar(x);
        return Math.pow(base, argumento);
    }

    @Override
    public String identificarTipo() {
        return "Exponencial";
    }
}