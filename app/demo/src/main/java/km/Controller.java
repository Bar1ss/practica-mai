package km;

import java.io.IOException;

import javafx.fxml.FXML;

public class Controller {

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
 