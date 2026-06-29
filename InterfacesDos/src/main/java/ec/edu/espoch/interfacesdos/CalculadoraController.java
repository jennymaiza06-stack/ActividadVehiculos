package ec.edu.espoch.interfacesdos;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculadoraController {

    @FXML
    private TextField txtPantalla;

    private String operacion = "";
    private double numero1 = 0;

    @FXML
    private void escribir(javafx.event.ActionEvent e) {

        String valor = ((javafx.scene.control.Button)e.getSource()).getText();

        if(txtPantalla.getText().equals("0")){
            txtPantalla.setText(valor);
        }else{
            txtPantalla.appendText(valor);
        }

    }

    @FXML
    private void limpiar(){

        txtPantalla.setText("0");

        numero1=0;

        operacion="";

    }

    @FXML
    private void operador(javafx.event.ActionEvent e){

        numero1=Double.parseDouble(txtPantalla.getText());

        operacion=((javafx.scene.control.Button)e.getSource()).getText();

        txtPantalla.setText("0");

    }

    @FXML
    private void igual(){

        double numero2=Double.parseDouble(txtPantalla.getText());

        double resultado=0;

        switch(operacion){

            case "+":
                resultado=numero1+numero2;
                break;

            case "-":
                resultado=numero1-numero2;
                break;

            case "×":
                resultado=numero1*numero2;
                break;

            case "÷":
                resultado=numero1/numero2;
                break;

        }

        txtPantalla.setText(String.valueOf(resultado));

    }

}