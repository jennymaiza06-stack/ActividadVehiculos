package ec.edu.espoch.proyectointegrador.Model.objects;


public abstract class Operacion {

    protected double resultado;

    public Operacion() {
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public abstract double calcular();

}
