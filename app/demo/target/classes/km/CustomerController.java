import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class CustomerController {
    @FXML
    private TableView<Customer> personTable = new TableView<>();
    @FXML
    private TableColumn<Customer, String> firstNameColumn;
    @FXML
    private TableColumn<Customer, String> lastNameColumn;
    @FXML
    private TableColumn<Customer, String> phoneNumberColumn;
    @FXML
    private TableColumn<Customer, String> addingDateColumn;
    @FXML
    private Button exit;
    @FXML
    private Button info;
    @FXML
    private TextField filterField;
    @FXML
    private AnchorPane backgr;
    private Stage dialogStage;
    private static ObservableList<Customer> personData = FXCollections.observableArrayList();
    public static void addCustomer(Customer customer){
        personData.add(customer);
    }

    @FXML
    private void initialize() {
        backgr.setStyle(HelloController.getStyle());
        personTable.setItems(personData);
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        addingDateColumn.setCellValueFactory(new PropertyValueFactory<>("addingDate"));

        info.setOnMouseClicked(event -> {
            info.getScene().getWindow().hide();
            ClientCardController.setCustomer(personTable.getSelectionModel().getSelectedItem());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ClientCard.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Информация о клиенте");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        });
        exit.setOnMouseClicked(event -> {
            exit.getScene().getWindow().hide();
        });
    }
    @FXML
    private void handleDeletePerson() {
        Customer selectedCustomer = personTable.getSelectionModel().getSelectedItem();
        if (selectedCustomer != null) {
            personData.remove(selectedCustomer);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(dialogStage);
            alert.setTitle("Не выбрано");
            alert.setHeaderText("Не выбран пользователь");
            alert.setContentText("Пожалуйста, выберите пользователя в таблице.");
            alert.showAndWait();
        }
    }
    @FXML
    private void clickSearch(){
        FilteredList<Customer> filteredData = new FilteredList<>(personData, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(customer -> {
                if (newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (customer.getFirstName().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if (customer.getLastName().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if (customer.getPhoneNumber().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else
                    return false;
            });
        });
        SortedList<Customer> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(personTable.comparatorProperty());
        personTable.setItems(sortedData);
    }
}
 
