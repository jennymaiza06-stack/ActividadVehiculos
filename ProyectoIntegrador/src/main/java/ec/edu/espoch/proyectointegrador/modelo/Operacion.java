package ec.edu.espoch.proyectointegrador.modelo;

// Superclase abstracta
public abstract class Operacion {

    protected double resultado;

    public Operacion() {
    }

    // Retorna el resultado calculado
    public double getResultado() {
        return this.resultado;
    }

    // Asigna el resultado
    public void setResultado(double result) {
        this.resultado = result;
    }

   
    public abstract double calcular();
}
