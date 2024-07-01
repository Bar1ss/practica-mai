package km;

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

public class TableController {
    @FXML
    private TableView<Adding> table = new TableView<>();
    @FXML
    private TableColumn<Adding, String> categoryColumn;
    @FXML
    private TableColumn<Adding, String> sumColumn;
    @FXML
    private TableColumn<Adding, String> dateColumn;
    @FXML
    private TableColumn<Adding, String> descriptionColumn;
    @FXML
    private Button exit;
    @FXML
    private Button info;
    @FXML
    private TextField filterField;
    @FXML
    private AnchorPane backgr;
    private Stage dialogStage;
    //private ClientCardController clientCardController = new ClientCardController();
    private static ObservableList<Adding> personData = FXCollections.observableArrayList();
    public static void addCost(Adding cost){
        personData.add(cost);
    }

    public TableController() {
    }

    @FXML
    private void initialize() {
        // Инициализация таблицы адресатов с двумя столбцами.
        table.setItems(personData);
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        sumColumn.setCellValueFactory(new PropertyValueFactory<>("sum"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        info.setOnMouseClicked(event -> {
            info.getScene().getWindow().hide();
            //ClientCardController.setCustomer(personTable.getSelectionModel().getSelectedItem());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Cost.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setTitle("Информация расходах");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        });
        exit.setOnMouseClicked(event -> {
            exit.getScene().getWindow().hide();
        });
    }
    // @FXML
    // private void handleDeletePerson() {
    //     Adding selectedCustomer = table.getSelectionModel().getSelectedItem();
    //     if (selectedCustomer != null) {
    //         personData.remove(selectedCustomer);
    //     } else {
    //         // Ничего не выбрано.
    //         Alert alert = new Alert(Alert.AlertType.WARNING);
    //         alert.initOwner(dialogStage);
    //         alert.setTitle("Не выбрано");
    //         alert.setHeaderText("Не выбран пользователь");
    //         alert.setContentText("Пожалуйста, выберите пользователя в таблице.");
    //         alert.showAndWait();
    //     }
    // }
    @FXML
    private void clickSearch(){
        FilteredList<Adding> filteredData = new FilteredList<>(personData, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(customer -> {
                if (newValue == null || newValue.isEmpty()){
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (customer.getCategory().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if (customer.getSum().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else if (customer.getDescription().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                else
                    return false;
            });
        });
        SortedList<Adding> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }
}