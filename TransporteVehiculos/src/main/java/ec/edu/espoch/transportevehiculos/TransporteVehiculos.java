/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espoch.transportevehiculos;


public class TransporteVehiculos {

    public static void main(String[] args) {
    
        Vehiculo carro = new Carro();
        Vehiculo moto = new Moto();
        Vehiculo  avion = new Avion();

        System.out.println("Transporte de productos");
    
        carro.transportar();  
        System.out.println("Distancia del Carro: " + carro.calcularDistancia(80)+ "km/h");
        
            
        moto.transportar();
        System.out.println("Distancia de la Moto: " + moto.calcularDistancia(80, 3)+ "km/h");
        
        avion.transportar(); 
        System.out.println("Distancia del Avion: " + avion.calcularDistancia(80, 3, 0.95)+ "km/h");
        
                
    }
}