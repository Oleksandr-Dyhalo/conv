module com.itproger.converter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.itproger.converter to javafx.fxml;
    exports com.itproger.converter;
}