/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espoch.micuartoproyecto;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class MiCuartoProyecto {

    public static void main(String[] args) {
        System.out.println();
         
        Scanner leer = new Scanner (System. in);
                
        int cont=0;
        double pMax=0.0;
        for (int i = 1; i < 6; i++) {
            System.out.println("Ingrese el peso:");
            double peso = leer.nextDouble();
            if(peso>=50.0){ 
                cont=cont+1;
                if(peso>pMax){
                    pMax=peso;
                }
            }
        }
        System.out.println("N.sacos:"+cont);
        System.out.println("peso Maximo:"+pMax);
    }
    
}
