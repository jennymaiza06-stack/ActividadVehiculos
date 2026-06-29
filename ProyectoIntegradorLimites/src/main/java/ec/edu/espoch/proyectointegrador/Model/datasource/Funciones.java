package ec.edu.espoch.proyectointegrador.Model.datasource;

import ec.edu.espoch.proyectointegrador.Model.daointerface.DaoFuncion;
import ec.edu.espoch.proyectointegrador.Model.objects.Funcion;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class Funciones implements DaoFuncion {

    private Funcion[] funciones;
    private int indice;

    //Constructor
   public Funciones() {
    this.funciones = new Funcion[10];
    this.indice = 0;
}
    //Metodos

@Override
public void identificarTipo(Funcion funcion) {
    String exp = funcion.getExpresion().toLowerCase();
    StringBuilder tipos = new StringBuilder();

    if (exp.contains("sin") || exp.contains("cos") || exp.contains("tan")) {
        tipos.append("Trigonométrica + ");
    }
    if (exp.contains("log") || exp.contains("ln")) {
        tipos.append("Logarítmica + ");
    }
    if (exp.contains("sqrt") || exp.contains("\u221A")) {
        tipos.append("Radical + ");
    }
    if (exp.contains("/")) {
        tipos.append("Racional + ");
    }
    if (exp.contains("^")) {
        tipos.append("Polinómica + ");
    }

    String tipo;
    if (tipos.length() == 0) {
        tipo = "Lineal";
    } else {
        tipo = tipos.substring(0, tipos.length() - 3); 
    }

    funcion.setTipoFuncion(tipo);
}

    @Override
    public boolean agregar(Funcion funcion) {
        if (indice < funciones.length) {
            funciones[indice] = funcion;
            indice++;
            return true;
        }
        return false;
    }

    @Override
    public double evaluar(Funcion funcion, double x) {
        String expresion = preprocesar(funcion.getExpresion());

        ExpressionBuilder armador = new ExpressionBuilder(expresion);
        armador.variable("x");
        Expression formula = armador.build();
        formula.setVariable("x", x);

        return formula.evaluate();
    }

    public Funcion[] getFunciones() { return funciones; }
    public int getIndice() { return indice; }

    @Override
    public void print() {
        for (int i = 0; i < indice; i++) {
            System.out.println((i + 1) + ". "
                + funciones[i].getNombre()
                + " = "
                + funciones[i].getExpresion());
        }
    }


 private String preprocesar(String expresion) {
        expresion = expresion.replace(" ", "");
        expresion = expresion.toLowerCase();
        expresion = expresion.replace("\u221A(", "sqrt(");
        expresion = expresion.replace("ln(", "log(");

        String resultado = "";
        for (int i = 0; i < expresion.length(); i++) {
            char actual = expresion.charAt(i);
            char siguiente = (i + 1 < expresion.length()) ? expresion.charAt(i + 1) : ' ';

            resultado += actual;

            if (Character.isDigit(actual) && siguiente == 'x') {
                resultado += "*";
            }
        }
        return resultado;
    }
}