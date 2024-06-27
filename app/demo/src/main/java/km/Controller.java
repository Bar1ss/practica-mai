package km;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
    
    @FXML
    private Button secondaryButton;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("cost_accounting");
    }
    @FXML
    private void switchToThirdy() throws IOException {
        App.setRoot("setting");
    }
}
 