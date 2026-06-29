package ec.edu.espoch.proyectointegrador.Model.objects;


public class Constante extends Expresion {

    private double valor;

    //Constructor
    public Constante(double valor) {
        this.valor = valor;
    }

    //Metodos
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public double evaluar(double x) {

        return valor;

    }

    @Override
    public String identificarTipo() {

        return "constante";

    }

}