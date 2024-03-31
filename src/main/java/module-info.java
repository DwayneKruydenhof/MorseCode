module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.morsecodeapp to javafx.fxml;
    exports com.morsecodeapp;
}