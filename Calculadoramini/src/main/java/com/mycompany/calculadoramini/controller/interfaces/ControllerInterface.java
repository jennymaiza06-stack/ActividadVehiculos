package com.mycompany.calculadoramini.controller.interfaces;

import com.mycompany.calculadoramini.controller.model.ControllerModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerInterface {

    @FXML
    private TextField txtNumero1;

    @FXML
    private TextField txtNumero2;

    @FXML
    private Label lblResultado;

    private ControllerModel controllerModel;

    @FXML
    public void initialize() {
        controllerModel = new ControllerModel(this);
    }

    private double getN1() {
        return Double.parseDouble(txtNumero1.getText().trim());
    }

    private double getN2() {
        return Double.parseDouble(txtNumero2.getText().trim());
    }

   
    @FXML
    private void handleSumar() {
        try {
            controllerModel.sumar(getN1(), getN2());
        } catch (Exception e) {
            mostrarerror();
        }
    }

    // ➖ RESTA
    @FXML
    private void handleRestar() {
        try {
            controllerModel.restar(getN1(), getN2());
        } catch (Exception e) {
            mostrarerror();
        }
    }

   
    @FXML
    private void handleMultiplicar() {
        try {
            controllerModel.multiplicar(getN1(), getN2());
        } catch (Exception e) {
            mostrarerror();
        }
    }

    @FXML
    private void handleDividir() {
        try {
            controllerModel.dividir(getN1(), getN2());
        } catch (Exception e) {
            mostrarerror();
        }
    }

   
    public void mostrar(double resultado) {
        lblResultado.setText("Resultado: " + resultado);
    }

  
    public void mostrarerror() {
        lblResultado.setText("Error: ingresa números válidos");
    }
}