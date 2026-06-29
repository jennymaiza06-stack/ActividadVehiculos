package com.mycompany.calculadora.model.data;

import com.mycompany.calculadora.model.access.InterCalculadora;
import com.mycompany.calculadora.model.object.Calculadora;

public class Calculadoras implements InterCalculadora {
    public double sumar(Calculadora calculadora) {
        return calculadora.getNumeroUno() + calculadora.getNumeroDos();
    }
}
