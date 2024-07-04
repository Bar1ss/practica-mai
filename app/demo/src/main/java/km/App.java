package km;

//import java.io.BufferedOutputStream;
//import java.io.BufferedWriter;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
//import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
//import javafx.geometry.Orientation;
//import javafx.scene.layout.AnchorPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException { //окно ff
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Учёт расходов");
        Image anotherIcon = new Image("file:C:\\Users\\User\\Desktop\\Уник\\программирование\\Практика\\practica-main\\app\\demo\\src\\main\\java\\km\\HavnyShishi.png");
        stage.getIcons().add(anotherIcon);

         TextField textField = new TextField();
        Button saveButton = new Button("Save Data");

        // saveButton.setOnAction(e -> {
        //     String data = textField.getText();
        //     saveDataToFile(data);
        // });

        VBox root = new VBox(10, textField, saveButton);
        @SuppressWarnings("unused")
        Scene scene = new Scene(root, 300, 200);

        stage.show();
      //  addBase();
    }

    // private void saveDataToFile(String data) {
    //     try (BufferedWriter writer = new BufferedWriter(new FileWriter("TableAdd.txt"))) {
    //         writer.write(data);
    //         System.out.println("Data saved successfully!");
    //     } catch (IOException e) {
    //         System.err.println("Error saving data: " + e.getMessage());
    //     }
    // }
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        // String text = "Hello world!"; // строка для записи
        // try(FileOutputStream out=new FileOutputStream("notes.txt"); 
        //         BufferedOutputStream bos = new BufferedOutputStream(out))
        // {
        //     // перевод строки в байты
        //     byte[] buffer = text.getBytes();
        //     bos.write(buffer, 0, buffer.length);
        // }
        // catch(IOException ex){
             
        //     System.out.println(ex.getMessage());f
        // } 

        launch();
    }

    // private void addBase(){
    //     TableController.addCost(new Adding("Продукты", "2000", "29-06-2024", "Чипсеки", 1));
    //     TableController.addCost(new Adding("Детали", "2000", "29-06-2024", "шурупы", 2));
    //     TableController.addCost(new Adding("Техника", "2000", "29-06-2024", "Ремонт ноутбука", 3));
    //     TableController.addCost(new Adding("Продукты", "2000", "29-06-2024", "Чипсеки", 4));
    //     TableController.addCost(new Adding("Продукты", "2000", "29-06-2024", "Чипсеки", 5));
    //     TableController.addCost(new Adding("Техника", "2000", "29-06-2024", "Чистка ПК", 6));
    //     TableController.addCost(new Adding("Техника", "2000", "29-06-2024", "Ремонт клавиатуры", 7));
        
    // }
      
} 