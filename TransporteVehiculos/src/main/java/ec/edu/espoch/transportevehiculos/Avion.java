/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.transportevehiculos;

import TransporteDao.DaoVehiculo;


public class Avion extends Vehiculo implements DaoVehiculo {

    public Avion() {
    }

    public Avion(float Velocidad, float Tiempo, float Eficiencia) {
        super(Velocidad, Tiempo, Eficiencia);
    }
    
    @Override
    public void transportar() {
        System.out.println("El avión transporta productos grandes o internacionales de forma rápida por aire.");
    }
}

