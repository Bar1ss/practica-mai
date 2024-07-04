package km;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.io.IOException;

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
    private TableColumn<inf, String> sumColumn;
    @FXML
    private TableColumn<inf, String> dateColumn;
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


    @FXML
    private void initialize() {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        categoryColumn.setCellValueFactory(new PropertyValueFactory<inf, String>("category"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<inf, String>("description"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<inf, String>("date"));
        sumColumn.setCellValueFactory(new PropertyValueFactory<inf, String>("sum"));

        // заполняем таблицу данными
        table.setItems(usersData);

        /*редактирование ячеек */
        categoryColumn.setCellFactory( TextFieldTableCell.<inf>forTableColumn());
        descriptionColumn.setCellFactory( TextFieldTableCell.<inf>forTableColumn());
        dateColumn.setCellFactory( TextFieldTableCell.<inf>forTableColumn());
        sumColumn.setCellFactory( TextFieldTableCell.<inf>forTableColumn());

        /* Подгрузка категорий и категория по умолчанию */
        categoryFilBox.setItems(categoryFilList);   
        categoryFilBox.setValue("Еда");
    }

    /* Заполнение таблицы */
    private void initData() {
        usersData.add(new inf("Еда", "Чипсы", "12.05.2024", "65"));
        usersData.add(new inf("Еда", "Чай", "12.05.2024", "90"));
        usersData.add(new inf("Еда", "Шаурма", "13.05.2024", "200"));
        usersData.add(new inf("Другое", "Дополнительные занятия", "20.05.2024", "2500"));
        usersData.add(new inf("Бытовые товары", "Блески для губ с котятами", "31.05.2024", "450"));
    }


    /* Заполнение категорий */
    @FXML
    private ChoiceBox categoryFilBox;

    ObservableList<String> categoryFilList = FXCollections.observableArrayList("Еда", "Одежда", "Техника", "Бытовые товары", "Налоги", "Другое");

}