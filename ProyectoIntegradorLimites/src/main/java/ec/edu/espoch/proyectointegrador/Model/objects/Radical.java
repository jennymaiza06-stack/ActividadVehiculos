package ec.edu.espoch.proyectointegrador.Model.objects;


public class Radical extends Expresion {

    //Atributos
    private int indice;
    private Expresion subExpresion;
    
    //Constructor

    public Radical(int indice, Expresion subExpresion) {
        this.indice = indice;
        this.subExpresion = subExpresion;
    }
    
    //Metodos

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
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
        if (indice == 2) {
            return Math.sqrt(argumento);
        }
        return Math.pow(argumento, 1.0 / indice);
    }

    @Override
    public String identificarTipo() {
        return "Radical";
    }
}