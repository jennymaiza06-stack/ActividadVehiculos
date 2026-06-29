package com.mycompany.calculadora.controller.interfaces;

import com.mycompany.calculadora.controller.model.ControllerModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerInter {

    private ControllerModel controllerModel;

    @FXML
    private TextField txtNumeroUno;

    @FXML
    private TextField txtNumeroDos;

    @FXML
    private Label lblResultado;

    @FXML
    private void initialize() {
        controllerModel = new ControllerModel(this);
    }

    private double getN1() throws Exception {
        return validar(txtNumeroUno.getText());
    }

    private double getN2() throws Exception {
        return validar(txtNumeroDos.getText());
    }

    private double validar(String valor) throws Exception {
        if (valor == null || valor.trim().isEmpty()) {
            throw new Exception("Campo vacío");
        }
        return Double.parseDouble(valor);
    }

    @FXML
    private void sumar() {
        controllerModel.sumar(getSafeN1(), getSafeN2());
    }

    @FXML
    private void restar() {
        controllerModel.restar(getSafeN1(), getSafeN2());
    }

    @FXML
    private void multiplicar() {
        controllerModel.multiplicar(getSafeN1(), getSafeN2());
    }

    @FXML
    private void dividir() {
        controllerModel.dividir(getSafeN1(), getSafeN2());
    }

    @FXML
    private void potencia() {
        controllerModel.potencia(getSafeN1(), getSafeN2());
    }

    @FXML
    private void raiz() {
        controllerModel.raiz(getSafeN1());
    }

    @FXML
    private void seno() {
        controllerModel.seno(getSafeN1());
    }

    @FXML
    private void coseno() {
        controllerModel.coseno(getSafeN1());
    }

    private double getSafeN1() {
        try {
            return getN1();
        } catch (Exception e) {
            mostrarError();
            return 0;
        }
    }

    private double getSafeN2() {
        try {
            return getN2();
        } catch (Exception e) {
            mostrarError();
            return 0;
        }
    }

    public void mostrar(double resultado) {
        lblResultado.setText("Resultado: " + resultado);
    }

    public void mostrarError() {
        lblResultado.setText("Error en los datos");
    }
}