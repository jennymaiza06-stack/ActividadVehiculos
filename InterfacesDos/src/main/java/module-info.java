module ec.edu.espoch.interfacesdos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    

    opens ec.edu.espoch.interfacesdos to javafx.fxml;
    exports ec.edu.espoch.interfacesdos;
}
