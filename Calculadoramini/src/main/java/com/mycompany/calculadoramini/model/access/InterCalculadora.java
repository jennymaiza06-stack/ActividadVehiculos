package com.mycompany.calculadoramini.model.access;

import com.mycompany.calculadoramini.model.object.Calculadora;

public interface InterCalculadora {

    double sumar(Calculadora c);

    double restar(Calculadora c);

    double multiplicar(Calculadora c);

    double dividir(Calculadora c);
}