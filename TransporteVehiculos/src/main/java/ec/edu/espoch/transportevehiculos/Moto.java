/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.transportevehiculos;

import TransporteDao.DaoVehiculo;

public class Moto extends Vehiculo implements DaoVehiculo {

   
    public Moto(float Velocidad, float Tiempo, float Eficiencia) {
        super(Velocidad, Tiempo, Eficiencia);
    }


    
    @Override
    public void transportar() {
        System.out.println("La moto transporta productos pequeños rápidamente en áreas urbanas.");
    }
}
    

