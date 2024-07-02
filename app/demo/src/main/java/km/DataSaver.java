package km;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataSaver extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        Button saveButton = new Button("Save Data");

        saveButton.setOnAction(e -> {
            String data = textField.getText();
            saveDataToFile(data);
        });

        VBox root = new VBox(10, textField, saveButton);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Data Saver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void saveDataToFile(String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("saved_data.txt"))) {
            writer.write(data);
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}