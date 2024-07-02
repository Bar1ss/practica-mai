package km;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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
    @FXML
    private void switchToFourty() throws IOException {
        App.setRoot("TableAdd");
    }


    private int theme = 0;

    @FXML
    private VBox background;
    @FXML
    private Text text;
    @FXML
    private Button button;
    @FXML
    private String type;
    @FXML
    private String textColor;

    @FXML
    public void switchTheme() {
        if (theme == 0) { //тёма
            theme += 1;
            // type = "#7c5894";
            // textColor = "#f1e3ff";
            background.setStyle("-fx-background-color:#7c5894"); //рабочее
            button.setStyle("-fx-background-color:#7c5894");
            text.setStyle("-fx-font:#f1e3ff");
        }
        else if(theme == 1) { //света
            theme -= 1;
            // type = "#f1e3ff";
            // textColor = "#731196";
            background.setStyle("-fx-background-color:#f1e3ff"); //рабочее
            button.setStyle("-fx-background-color:#f1e3ff");
            text.setStyle("-fx-font:#731196");
        }

        // background.setStyle("-fx-background-color:" + type); //рабочее
        // button.setStyle("-fx-background-color:" + type);
        // text.setStyle("-fx-font:" + textColor);
    }


}
 