package ec.edu.espoch.proyectointegrador.dao;

import ec.edu.espoch.proyectointegrador.modelo.Limite;

// Implementa la interfaz Operaciones y gestiona el historial de resultados
public class GestorLimites implements Operaciones {

    private double[] historial;
    private int indice;

    public GestorLimites() {
        this.historial = new double[10];
        this.indice = 0;
    }

    // Delega el calculo al objeto Limite (polimorfismo con @Override)
    @Override
    public double calcularLimite(Limite limite) {
        return limite.calcular();
    }

    // Guarda el resultado en el arreglo. Si esta lleno, avisa al usuario.
    @Override
    public void guardarHistorial(double result) {
        if (this.indice < this.historial.length) {
            this.historial[this.indice] = result;
            this.indice++;
        } else {
            System.out.println("  Historial lleno: maximo " + this.historial.length + " resultados.");
        }
    }

    // Retorna el arreglo completo
    @Override
    public double[] getHistorial() {
        return this.historial;
    }

    // Retorna cuantos resultados hay guardados
    public int getCantidadGuardados() {
        return this.indice;
    }
}