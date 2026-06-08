/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.transportevehiculos;


public abstract class Vehiculo {

  
    // Sobrecarga de métodos
    public double calcularDistancia(double velocidad) {
        return velocidad * 1;
    }

    public double calcularDistancia(double velocidad, double tiempo) {
        return velocidad * tiempo;
    }

    public double calcularDistancia(double velocidad, double tiempo, double eficiencia) {
        return velocidad * tiempo * eficiencia;
    }

    // Método abstracto
    public abstract void transportar();
}
