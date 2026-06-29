package ec.edu.espoch.proyectointegrador.Model.datasource;

import ec.edu.espoch.proyectointegrador.Model.daointerface.DaoLimite;
import ec.edu.espoch.proyectointegrador.Model.objects.Historial;
import ec.edu.espoch.proyectointegrador.Model.objects.Limite;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class Limites implements DaoLimite {

    private Lista lista;

    //Constructor
    public Limites() {
        this.lista = new Lista();
    }

    //Metodos
   @Override
    public double calcularLimite(Limite limite) {
        String expresion = preprocesar(limite.getFuncion().getExpresion());
        double valorX = limite.getValorX();
        double h = 0.0001;

       
        int abre = 0;
        int cierra = 0;
        for (int i = 0; i < expresion.length(); i++) {
            if (expresion.charAt(i) == '(') abre++;
            if (expresion.charAt(i) == ')') cierra++;
        }
        if (abre != cierra) {
            limite.setAproximacion("paréntesis");
            limite.setResultado(Double.NaN);
            return Double.NaN;
        }

        ExpressionBuilder armador = new ExpressionBuilder(expresion);
        armador.variable("x");
        Expression formula = armador.build();

       
        double enElPunto;
        try {
            formula.setVariable("x", valorX);
            enElPunto = formula.evaluate();
        } catch (ArithmeticException e) {
            enElPunto = Double.NaN;
        }

        double resultado;
        String aproximacion;

        if (Double.isNaN(enElPunto) || Double.isInfinite(enElPunto)) {
        
            double izquierda;
            try {
                formula.setVariable("x", valorX - h);
                izquierda = formula.evaluate();
            } catch (ArithmeticException e) {
                izquierda = Double.NaN;
            }

            double derecha;
            try {
                formula.setVariable("x", valorX + h);
                derecha = formula.evaluate();
            } catch (ArithmeticException e) {
                derecha = Double.NaN;
            }

            if (Double.isNaN(izquierda) || Double.isNaN(derecha)) {
                resultado = Double.NaN;
                aproximacion = "no existe";
            } else if (Math.abs(izquierda - derecha) < 0.001) {
                resultado = (izquierda + derecha) / 2;
                aproximacion = "indeterminado";
            } else {
                resultado = Double.NaN;
                aproximacion = "no existe";
            }
        } else {
          
            resultado = enElPunto;
            aproximacion = "ambos";
        }

        if (!Double.isNaN(resultado) && !Double.isInfinite(resultado)) {
            resultado = Math.round(resultado * 1000000.0) / 1000000.0;
        }

        limite.setAproximacion(aproximacion);
        limite.setResultado(resultado);
        return resultado;
    }

    @Override
    public void guardarHistorial(Historial historial) {
        lista.agregar(historial);
    }

    @Override
    public Historial[] getHistorial() {
        return lista.getDatos();
    }

    public int getCantidadGuardados() {
        return lista.getTamanio();
    }

    @Override
    public void print() {
        System.out.println("HISTORIAL");
        for (int i = 0; i < lista.getTamanio(); i++) {
            Historial h = lista.obtener(i);
            System.out.println((i + 1) + ". " + h.getDescripcion() + " -> " + h.getResultado());
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