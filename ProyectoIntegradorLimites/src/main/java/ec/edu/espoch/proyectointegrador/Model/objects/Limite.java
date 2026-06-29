package ec.edu.espoch.proyectointegrador.Model.objects;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class Limite extends Operacion {

    private double valorX;
    private String aproximacion;
    private Funcion funcion;

    //Constructor
    public Limite() {
    }

    public Limite(Funcion funcion, double valorX, String aproximacion) {
        this.funcion = funcion;
        this.valorX = valorX;
        this.aproximacion = aproximacion;
    }

    public double getValorX() {
        return valorX;
    }

    public void setValorX(double valorX) {
        this.valorX = valorX;
    }

    public String getAproximacion() {
        return aproximacion;
    }

    public void setAproximacion(String aproximacion) {
        this.aproximacion = aproximacion;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

 @Override
    public double calcular() {
        String exp = funcion.getExpresion().toLowerCase();
        exp = exp.replace("\u221A(", "sqrt(");
        exp = exp.replace("ln(", "log(");

        String preparada = "";
        for (int i = 0; i < exp.length(); i++) {
            char actual = exp.charAt(i);
            char siguiente = (i + 1 < exp.length()) ? exp.charAt(i + 1) : ' ';
            preparada += actual;
            if (Character.isDigit(actual) && siguiente == 'x') {
                preparada += "*";
            }
        }

        ExpressionBuilder armador = new ExpressionBuilder(preparada);
        armador.variable("x");
        Expression formula = armador.build();
        formula.setVariable("x", valorX);

        resultado = formula.evaluate();
        return resultado;
    }
}