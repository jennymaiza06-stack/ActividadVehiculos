/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.transportevehiculos;

import TransporteDao.DaoVehiculo;

public class Carro extends Vehiculo implements DaoVehiculo {

    public Carro() {
    }

    public Carro(float Velocidad, float Tiempo, float Eficiencia) {
        super(Velocidad, Tiempo, Eficiencia);
    }

    

    @Override
    public void transportar() {
        System.out.println("El carro transporta productos por carretera de forma eficiente.");
    }
}
   
