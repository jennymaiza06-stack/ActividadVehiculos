package ec.edu.espoch.proyectointegrador.Controller.Interfaces;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import ec.edu.espoch.proyectointegrador.Controller.Model.ControllerModel;
import ec.edu.espoch.proyectointegrador.Model.objects.Historial;

public class Vista implements Initializable {

    @FXML
    private TextField campoExpresion;
    @FXML
    private TextField campoValorX;
    @FXML
    private Label lblResultado;
    @FXML
    private TextArea areaProcedimiento;
    @FXML
    private Button botonVerHistorial;
    @FXML
    private LineChart<Number, Number> graficoLimite;

    private ControllerModel controlador;

    private XYChart.Series<Number, Number> curva;
    private XYChart.Series<Number, Number> punto;
    private int ultimaPosicionCursor = 0;
    

  @Override
public void initialize(URL url, ResourceBundle rb) {
    controlador = new ControllerModel(this);
    graficoLimite.setAnimated(false);

    // Inicializar ambas series y agregarlas al gráfico
    curva = new XYChart.Series<>();
    curva.setName("f(x)");
    punto = new XYChart.Series<>();
    punto.setName("Limite");
    graficoLimite.getData().add(curva);
    graficoLimite.getData().add(punto);

    campoExpresion.setOnMouseReleased(e -> ultimaPosicionCursor = campoExpresion.getCaretPosition());
    campoExpresion.setOnKeyReleased(e -> ultimaPosicionCursor = campoExpresion.getCaretPosition());
}

    public String getExpresion() {
        return campoExpresion.getText();
    }

    public String getValorX() {
        return campoValorX.getText();
    }

    public void mostrarResultado(String procedimiento) {
        areaProcedimiento.setText(procedimiento);

        String[] lineas = procedimiento.split("\n");
        String ultimaLinea = lineas[lineas.length - 1];
        int posIgual = ultimaLinea.indexOf("=");
        String valor = (posIgual >= 0) ? ultimaLinea.substring(posIgual + 1).trim() : ultimaLinea;
        lblResultado.setText(valor);
    }

    public void mostrarError() {
        lblResultado.setText("Error: revisa los datos ingresados");
    }

    public void mostrarHistorial(Historial[] historiales) {
        ContextMenu menu = new ContextMenu();
        boolean hayDatos = false;

        for (int i = 0; i < historiales.length; i++) {
            Historial h = historiales[i];
            if (h != null) {
                String valor;
                if (Double.isNaN(h.getResultado()) || Double.isInfinite(h.getResultado())) {
                    valor = "no existe";
                } else {
                    valor = "" + h.getResultado();
                }
                MenuItem item = new MenuItem(h.getDescripcion() + " = " + valor);
                menu.getItems().add(item);
                hayDatos = true;
            }
        }

        if (!hayDatos) {
            menu.getItems().add(new MenuItem("Todavia no hay cálculos guardados"));
        }

        menu.show(botonVerHistorial, Side.TOP, 0, -15);
    }

    public void mostrarGrafica(double[] valoresX, double[] valoresY, double limX, double limY) {
        curva.getData().clear();
        punto.getData().clear();

        for (int i = 0; i < valoresX.length; i++) {
            curva.getData().add(new XYChart.Data<Number, Number>(valoresX[i], valoresY[i]));
        }

        if (!Double.isNaN(limY) && !Double.isInfinite(limY)) {
            punto.getData().add(new XYChart.Data<Number, Number>(limX, limY));
        }
    }

    @FXML
    private void onCalcular() {
        controlador.calcularLimite();
    }

    @FXML
    private void onVerHistorial() {
        controlador.verHistorial();
    }

    @FXML
    private void onSalir() {
        System.exit(0);
    }

    @FXML
    private void onInsertarRaiz() {
        insertar("\u221A()");
    }

    @FXML
    private void onInsertarPotencia() {
        insertar("^");
    }

    @FXML
    private void onInsertarFraccion() {
        insertar("()/()");
    }

    @FXML
    private void onInsertarSeno() {
        insertar("sin()");
    }

    @FXML
    private void onInsertarCoseno() {
        insertar("cos()");
    }

    @FXML
    private void onInsertarTangente() {
        insertar("tan()");
    }

    @FXML
    private void onInsertarLn() {
        insertar("ln()");
    }

    @FXML
    private void onInsertarLog() {
        insertar("log10()");
    }

    @FXML
    private void onInsertarParentesisDoble() {
        insertar("()*()");
    }

    @FXML
    private void onInsertarParentesis() {
        insertar("()");
    }

 private void insertar(String texto) {
        campoExpresion.insertText(ultimaPosicionCursor, texto);
 
        int parentesis = texto.indexOf('(');
        int nuevaPosicion = (parentesis >= 0)
            ? ultimaPosicionCursor + parentesis + 1
            : ultimaPosicionCursor + texto.length();
 
        campoExpresion.positionCaret(nuevaPosicion);
        campoExpresion.requestFocus();
        ultimaPosicionCursor = nuevaPosicion;
    }
}