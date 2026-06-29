package com.mycompany.calculadoramini.controller.model;

import com.mycompany.calculadoramini.controller.interfaces.ControllerInterface;
import com.mycompany.calculadoramini.model.access.InterCalculadora;
import com.mycompany.calculadoramini.model.data.Calculadoras;
import com.mycompany.calculadoramini.model.object.Calculadora;

public class ControllerModel {

    private Calculadora calculadora;
    private ControllerInterface controllerInterface;
    private InterCalculadora metodosCalcu;

    public ControllerModel(ControllerInterface controllerInterface) {
        this.calculadora = new Calculadora();
        this.controllerInterface = controllerInterface;
        this.metodosCalcu = new Calculadoras();
    }

    public void sumar(double n1, double n2) {
        ejecutar(n1, n2, "sumar");
    }

    public void restar(double n1, double n2) {
        ejecutar(n1, n2, "restar");
    }

    public void multiplicar(double n1, double n2) {
        ejecutar(n1, n2, "multiplicar");
    }

    public void dividir(double n1, double n2) {
        if (n2 == 0) {
            controllerInterface.mostrarerror();
            return;
        }
        ejecutar(n1, n2, "dividir");
    }

    private void ejecutar(double n1, double n2, String op) {
        try {
            calculadora.setNumeroUno(n1);
            calculadora.setNumeroDos(n2);

            double resultado;

            switch (op) {
                case "sumar":
                    resultado = metodosCalcu.sumar(calculadora);
                    break;

                case "restar":
                    resultado = metodosCalcu.restar(calculadora);
                    break;

                case "multiplicar":
                    resultado = metodosCalcu.multiplicar(calculadora);
                    break;

                case "dividir":
                    resultado = metodosCalcu.dividir(calculadora);
                    break;

                default:
                    throw new IllegalArgumentException("Operación inválida");
            }

            controllerInterface.mostrar(resultado);

        } catch (Exception e) {
            controllerInterface.mostrarerror();
        }
    }
}