module comp296.caravan {
    requires javafx.controls;
    requires javafx.fxml;

    opens comp296.caravan to javafx.fxml;
    exports comp296.caravan;
}
