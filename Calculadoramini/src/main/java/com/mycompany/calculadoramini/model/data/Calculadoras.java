
package com.mycompany.calculadoramini.model.data;

import com.mycompany.calculadoramini.model.access.InterCalculadora;
import com.mycompany.calculadoramini.model.object.Calculadora;

public class Calculadoras implements InterCalculadora {

    @Override
    public double sumar(Calculadora c) {
        return c.getNumeroUno() + c.getNumeroDos();
    }

    @Override
    public double restar(Calculadora c) {
        return c.getNumeroUno() - c.getNumeroDos();
    }

    @Override
    public double multiplicar(Calculadora c) {
        return c.getNumeroUno() * c.getNumeroDos();
    }

    @Override
    public double dividir(Calculadora c) {
        if (c.getNumeroDos() == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return c.getNumeroUno() / c.getNumeroDos();
    }
}
