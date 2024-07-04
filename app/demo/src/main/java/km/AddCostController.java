// package km;
// import java.io.IOException;

// import javafx.fxml.FXML;
// import javafx.scene.control.Button;
// import javafx.scene.layout.AnchorPane;
// import javafx.stage.Stage;
// import javafx.scene.control.Alert;
// import javafx.scene.control.Alert.AlertType;
// import javafx.scene.control.TextField;

// import java.io.IOException;

// import javafx.fxml.FXML;
// import javafx.scene.control.Button;

// public class AddCostController {
//     // @FXML
//     // private Button secondaryButton;

//     // @FXML
//     // private void switchToPrimary() throws IOException {
//     //     App.setRoot("primary");
//     // }
    
//     // @FXML
//     // private void switchToSecondary() throws IOException {
//     //     App.setRoot("cost_accounting");
//     // }
//     // @FXML
//     // private void switchToThirdy() throws IOException {
//     //     App.setRoot("setting");
//     // }
    
//     @FXML
//     private TextField categoryField;
//     @FXML
//     private TextField sumField;
//     @FXML
//     private TextField dateField;
//     @FXML
//     private TextField descriptionField;
//     @FXML
//     private TextField IdField;
//     @FXML
//     private Button ok;
//     // @FXML
//     // private Button cancel;
//     // @FXML
//     // private AnchorPane backgr;
//     private Adding cost = new Adding();
//     private Stage dialogStage;
//     private boolean okClicked = false;
//     @FXML
//     private void initialize() {
//         ok.setOnMouseClicked(event -> {
//                 cost.setCategory(categoryField.getText());
//                 cost.setSum(sumField.getText());
//                 cost.setDescription(descriptionField.getText());
//                 cost.setId(Integer.parseInt(IdField.getText()));
//                 TableController.addCost(cost);
//                 okClicked = true;
//                 ok.getScene().getWindow().hide();

//                // Alert alert = new Alert(AlertType.INFORMATION);
//                 //alert.initOwner(dialogStage);
//                // alert.setTitle("Добавить");
//                // alert.setHeaderText("Данные добавлены");
//                // alert.showAndWait();
            
//         });
//      /*  cancel.setOnMouseClicked(event -> {
//             cancel.getScene().getWindow().hide();
//         }); */ 
//     }
//     public boolean isOkClicked() {
//         return okClicked;
//     }

// }
