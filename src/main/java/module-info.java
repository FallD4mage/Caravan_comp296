module comp296.caravan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens comp296.caravan to javafx.fxml;
    exports comp296.caravan;
}
