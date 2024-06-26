module km {
    requires javafx.controls;
    requires javafx.fxml;

    opens km to javafx.fxml;
    exports km;
}
