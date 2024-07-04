package km;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.collections.transformation.FilteredList;
//import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
//import javafx.stage.Stage;
import java.io.IOException;
//import km.inf;

public class TableController {

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
    }

    public ObservableList<inf> usersData = FXCollections.observableArrayList();

    @FXML
    private TableView<inf> table;
    @FXML
    private TableColumn<inf, String> categoryColumn;
    @FXML
    private TableColumn<inf, Integer> sumColumn;
    @FXML
    private TableColumn<inf, Integer> dateColumn;
    @FXML
    private TableColumn<inf, String> descriptionColumn;
    @FXML
    private Button exit;
    @FXML
    private Button info;
    @FXML
    private TextField filterField;
    @FXML
    private AnchorPane backgr;

   // private Stage dialogStage;

    //private ClientCardController clientCardController = new ClientCardController();

    // private static ObservableList<inf> personData = FXCollections.observableArrayList();

    // public static void addCost(int cost){
    //     personData.add(cost);
    // }

    // public TableController() {
    // }

    @FXML
    private void initialize() {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        categoryColumn.setCellValueFactory(new PropertyValueFactory<inf, String>("category"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<inf, String>("description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<inf, Integer>("date"));
        sumColumn.setCellValueFactory(new PropertyValueFactory<inf, Integer>("sum"));

        // заполняем таблицу данными
        table.setItems(usersData);
    }

    private void initData() {
        usersData.add(new inf("cat", "des", 32, 737));

    }










        // Инициализация таблицы адресатов с двумя столбцами.
    //     table.setItems(personData);
    //     categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
    //     sumColumn.setCellValueFactory(new PropertyValueFactory<>("sum"));
    //     dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
    //     descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

    //     info.setOnMouseClicked(event -> {
    //         info.getScene().getWindow().hide();
    //         //ClientCardController.setCustomer(personTable.getSelectionModel().getSelectedItem());
    //         FXMLLoader loader = new FXMLLoader();
    //         loader.setLocation(getClass().getResource("cost_accounting.fxml"));
    //         try {
    //             loader.load();
    //         } catch (IOException e) {
    //             throw new RuntimeException(e);
    //         }
    //         Parent root = loader.getRoot();
    //         Stage stage = new Stage();
    //         stage.setTitle("Информация о расходах");
    //         stage.setScene(new Scene(root));
    //         stage.setResizable(false);
    //         stage.show();
    //     });
    //     exit.setOnMouseClicked(event -> {
    //         exit.getScene().getWindow().hide();
    //     });
    // }
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


    // @FXML
    // private void clickSearch(){
    //     FilteredList<Adding> filteredData = new FilteredList<>(personData, b -> true);
    //     filterField.textProperty().addListener((observable, oldValue, newValue) -> {
    //         filteredData.setPredicate(customer -> {
    //             if (newValue == null || newValue.isEmpty()){
    //                 return true;
    //             }
    //             String lowerCaseFilter = newValue.toLowerCase();
    //             if (customer.getCategory().toLowerCase().contains(lowerCaseFilter)){
    //                 return true;
    //             }
    //             else if (customer.getSum().toLowerCase().contains(lowerCaseFilter)){
    //                 return true;
    //             }
    //             else if (customer.getDescription().toLowerCase().contains(lowerCaseFilter)){
    //                 return true;
    //             }
    //             else
    //                 return false;
    //         });
    //     });
    //     SortedList<Adding> sortedData = new SortedList<>(filteredData);
    //     sortedData.comparatorProperty().bind(table.comparatorProperty());
    //     table.setItems(sortedData);
    // }
}