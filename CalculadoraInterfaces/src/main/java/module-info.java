module com.mycompany.calculadoramini {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.calculadora to javafx.fxml;
    opens com.mycompany.calculadora.controller.interfaces to javafx.fxml;
    exports com.mycompany.calculadora;
}
