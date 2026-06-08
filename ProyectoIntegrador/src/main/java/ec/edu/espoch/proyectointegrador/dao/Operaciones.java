package ec.edu.espoch.proyectointegrador.dao;

import ec.edu.espoch.proyectointegrador.modelo.Limite;

// Interfaz que define las operaciones del sistema 
public interface Operaciones {

    double calcularLimite(Limite limite);

    void guardarHistorial(double result);

    double[] getHistorial();
}
