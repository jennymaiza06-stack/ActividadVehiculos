package ec.edu.espoch.proyectointegrador.Model.objects;


public class Termino  {
 
    private double coeficiente;
    private int exponente;
    private String signo;
 
    //Constructor
    public Termino(double coeficiente, int exponente, String signo) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
        this.signo = signo;
    }
 
    //Metodos
    public double getCoeficiente() {
        return coeficiente;
    }
 
    public void setCoeficiente(double coeficiente) {
        this.coeficiente = coeficiente;
    }
 
    public int getExponente() {
        return exponente;
    }
 
    public void setExponente(int exponente) {
        this.exponente = exponente;
    }
 
    public String getSigno() {
        return signo;
    }
 
    public void setSigno(String signo) {
        this.signo = signo;
    }
 
    public double evaluar(double x) {
        double valor = coeficiente * Math.pow(x, exponente);
        return signo.equals("-") ? -valor : valor;
    }

    public String identificarTipo() {
        return "Término";
    }
}

