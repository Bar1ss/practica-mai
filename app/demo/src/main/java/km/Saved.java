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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class Saved {
      @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("cost_accounting");
    }
    /* Ввод */


    @FXML
    private DatePicker picker;
    @FXML
    private TextArea category;   
    @FXML
    private TextArea sum;  
    @FXML
    private TextArea description;

    private Map<LocalDate, String> data = new HashMap<>();
    
    public void initialize() {
        load();

        picker.setValue(LocalDate.now());

        picker.valueProperty().addListener((o, oldDate, date) -> {
            category.setText(data.getOrDefault(date, "Данные отсутствуют"));
            sum.setText(data.getOrDefault(date, "Данные отсутствуют"));
            description.setText(data.getOrDefault(date, "Данные отсутствуют"));
        });

    }

       private void load() {
        Path file = Paths.get("TableAdd.data");

        if (Files.exists(file)) {
            try (ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(file))) {
                data = (Map<LocalDate, String>) stream.readObject();
                System.out.println("Loaded!");
            } catch (Exception e) {
                System.out.println("Failed to load: " + e);
            }
        }
    }

    public void updateNotes() {
        data.put(picker.getValue(), category.getText());
        data.put(picker.getValue(), sum.getText());
        data.put(picker.getValue(), description.getText());
    }

    public void exit() {
        save();
        Platform.exit();
    }

      private void save() {
        try (ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(Paths.get("TableAdd.data")))) {
            stream.writeObject(data);
            System.out.println("Saved!");
        } catch (Exception e) {
            System.out.println("Failed to save: " + e);
        }
    }
}
