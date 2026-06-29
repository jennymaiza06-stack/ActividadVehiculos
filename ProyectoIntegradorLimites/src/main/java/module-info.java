module ec.edu.espoch.proyectointegrador {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires exp4j;

    opens ec.edu.espoch.proyectointegrador to javafx.fxml;
    opens ec.edu.espoch.proyectointegrador.Controller.Interfaces to javafx.fxml;

    exports ec.edu.espoch.proyectointegrador;
}
