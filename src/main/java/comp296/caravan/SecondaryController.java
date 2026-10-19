package comp296.caravan;

import java.io.IOException;
import javafx.fxml.FXML;

//Preset class, came with project creation.
public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}