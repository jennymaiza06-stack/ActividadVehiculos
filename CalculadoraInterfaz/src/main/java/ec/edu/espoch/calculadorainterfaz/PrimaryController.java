package ec.edu.espoch.calculadorainterfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField txtNumero1;

    @FXML
    private TextField txtNumero2;

    @FXML
    private Label lblResultado;

    @FXML
    private void sumar() {

        double a = Double.parseDouble(txtNumero1.getText());
        double b = Double.parseDouble(txtNumero2.getText());

        lblResultado.setText(String.valueOf(a + b));
    }

    @FXML
    private void restar() {

        double a = Double.parseDouble(txtNumero1.getText());
        double b = Double.parseDouble(txtNumero2.getText());

        lblResultado.setText(String.valueOf(a - b));
    }

    @FXML
    private void multiplicar() {

        double a = Double.parseDouble(txtNumero1.getText());
        double b = Double.parseDouble(txtNumero2.getText());

        lblResultado.setText(String.valueOf(a * b));
    }

    @FXML
    private void dividir() {

        double a = Double.parseDouble(txtNumero1.getText());
        double b = Double.parseDouble(txtNumero2.getText());

        if (b == 0) {
            lblResultado.setText("No se puede dividir entre cero");
        } else {
            lblResultado.setText(String.valueOf(a / b));
        }
    }

}