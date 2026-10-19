package comp296.caravan;

import java.io.IOException;
import javafx.fxml.FXML;

//Preset class, came with project creation.
public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
