module com.example.taller5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;


    opens com.example.taller5 to javafx.fxml;
    exports com.example.taller5;
    exports com.example.taller5.Modelo;
    opens com.example.taller5.Modelo to javafx.fxml;
}