/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espoch.transportevehiculos;


public class TransporteVehiculos {

    public static void main(String[] args) {
    
        Vehiculo carro = new Carro(10,4,9);
        Vehiculo moto = new Moto(2,6,8);
        Vehiculo  avion = new Avion(57,8,91);

        System.out.println("Transporte de productos");
    
        carro.transportar();  
        System.out.println("Distancia del Carro: " + carro.calcularDistancia((float) carro.getVelocidad())+ "km/h");
        
            
        moto.transportar();
        System.out.println("Distancia de la Moto: " + moto.calcularDistancia((float) moto.getTiempo())+ "km/h");
        
        avion.transportar(); 
        System.out.println("Distancia del Avion: " + avion.calcularDistancia((float) avion.getEficiencia())+ "km/h");
        
                
    }
}