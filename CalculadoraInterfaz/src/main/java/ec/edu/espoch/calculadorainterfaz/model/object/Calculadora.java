
package ec.edu.espoch.calculadorainterfaz.model.object;

/**
 *
 * @author HP
 */
public class Calculadora {
    private double numeroUno;
private double numeroDos;

    public Calculadora(double numeroUno, double numeroDos) {
        this.numeroUno = numeroUno;
        this.numeroDos = numeroDos;
    }

    public Calculadora() {
    }
    
    public double getNumeroUno() {
        return numeroUno;
    }

    public void setNumeroUno(double numeroUno) {
        this.numeroUno = numeroUno;
    }

    public double getNumeroDos() {
        return numeroDos;
    }

    public void setNumeroDos(double numeroDos) {
        this.numeroDos = numeroDos;
    }

public double sumar (){
    return numeroUno+ numeroDos ;
}
    
}
