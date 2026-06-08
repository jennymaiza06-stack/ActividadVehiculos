/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espoch.figurasgeometricas;

/**
 *
 * @author HP
 */
public class FigurasGeometricas {

    public static void main(String[] args) {
        System.out.println("Datos Cuadrado");
        
        Cuadrado cuadrado = new Cuadrado(2);
        float areaCuadrado = cuadrado.calcularArea();
        float perimetroCuadrado = cuadrado.calcularPerimetro();
        System.out.println("Area: " + areaCuadrado );
        System.out.println("Perimetro" + perimetroCuadrado);
           
        
        System.out.println("Datos Rectángulo");
        
        Rectángulo rectángulo = new Rectángulo (4.3);
        float  areaRectángulo = rectángulocalcularArea();
        float  alturaRectángulo = rectángulo.calculoArea();
        System.out.println("Area: "+ areaRectangulo);
        System.out.println("Altura:"+ alturaRectángulo);
        
        
        System.out.println("Datos del Circulo");
        
        Circulo circulo = new circulo.calculaArea();
        float areaCirculo = circulo.calcularArea();
        float perimetroCirculo = circulo.calcularPerimetro();
        System.out.println("Area: "+ areaCirculo);
        System.out.println("Perimetro: "+ perimetroCirculo);
        
        
        
        System.out.println("Datos del Triangulo");
        
        Triangulo triangulo = new Triangulo(3,4);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        
                
       
    }
}
