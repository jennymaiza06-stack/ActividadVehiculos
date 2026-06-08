package ec.edu.espoch.proyectointegrador.modelo;

// Subclase de Operacion que representa el limite de una funcion en un punto
public class Limite extends Operacion {

    private double valorX;
    private Funcion funcion;

    public Limite() {
    }

    public Limite(Funcion f, double x) {
        this.funcion = f;
        this.valorX = x;
    }

    public double getValorX() {
        return this.valorX;
    }

    public void setValorX(double x) {
        this.valorX = x;
    }

    public Funcion getFuncion() {
        return this.funcion;
    }

    public void setFuncion(Funcion f) {
        this.funcion = f;
    }

    // Evalua la funcion en el punto x y guarda el resultado
    @Override
    public double calcular() {
        this.resultado = this.funcion.evaluar(this.valorX);
        return this.resultado;
    }
}
