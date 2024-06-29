package km;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class AddCustomerController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField carNumberField;
    @FXML
    private TextField carModelField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField clientIdField;
    @FXML
    private Button ok;
    @FXML
    private Button cancel;
    @FXML
    private AnchorPane backgr;
    private Adding cost = new Adding();
    private Stage dialogStage;
    private boolean okClicked = false;
    @FXML
    private void initialize() {
        ok.setOnMouseClicked(event -> {
                cost.setCategory(firstNameField.getText());
                cost.setSum(lastNameField.getText());
                cost.setDescription(carModelField.getText());
                cost.setId(Integer.parseInt(clientIdField.getText()));
                Controller.Adding(cost);
                okClicked = true;
                ok.getScene().getWindow().hide();

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.initOwner(dialogStage);
                alert.setTitle("Добавить");
                alert.setHeaderText("Данные добавлены");
                alert.showAndWait();
            
        });
     /*  cancel.setOnMouseClicked(event -> {
            cancel.getScene().getWindow().hide();
        }); */ 
    }
    public boolean isOkClicked() {
        return okClicked;
    }

}
