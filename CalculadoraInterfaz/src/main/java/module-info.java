module ec.edu.espoch.calculadorainterfaz {

    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espoch.calculadorainterfaz to javafx.fxml;

    exports ec.edu.espoch.calculadorainterfaz;
}