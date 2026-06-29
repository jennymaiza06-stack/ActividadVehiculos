module com.mycompany.calculadoramini {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.calculadoramini to javafx.fxml;
    opens com.mycompany.calculadoramini.controller.interfaces to javafx.fxml;
    exports com.mycompany.calculadoramini;
}
