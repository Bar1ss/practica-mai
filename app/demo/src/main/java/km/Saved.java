package km;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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

        picker.valueProperty().addListener((date) -> {
            category.setText(data.getOrDefault(date, "Данные отсутствуют"));
            sum.setText(data.getOrDefault(date, "Данные отсутствуют"));
            description.setText(data.getOrDefault(date, "Данные отсутствуют"));
        });

    }

    @SuppressWarnings("unchecked")
    private void load() {
        Path file = Paths.get("C:\\Users\\User\\Desktop\\Уник\\программирование\\Практика\\practica-main\\TableAdd.txt");

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
        try {
            switchToSecondary();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        LocalDate pickerText = picker.getValue();
        String categoryText = category.getText();
        String sumText = sum.getText();
        String descriptionText = description.getText();
        System.out.println(pickerText + " - " + categoryText + " - " + sumText + " - " + descriptionText);
        save();

}
    

    public void exit() {
        save();
        Platform.exit();
    }

      private void save() {
            String categoryText = category.getText() + "\n";
            String sumText = sum.getText() + "\n";
            String descriptionText = description.getText() + "\n";

           try (FileOutputStream out = new FileOutputStream("TableAdd.txt"); 
                BufferedOutputStream bos = new BufferedOutputStream(out))
        {
            // перевод строки в байты
            // LocalDate bufferpicker = pickerText; //не работает
            // bos.write(bufferpicker, 0, bufferpicker.length);
            byte[] buffercategory = categoryText.getBytes();
            bos.write(buffercategory, 0, buffercategory.length);
            byte[] buffersum = sumText.getBytes();
            bos.write(buffersum, 0, buffersum.length);
            byte[] bufferdescription = descriptionText.getBytes();
            bos.write(bufferdescription, 0, bufferdescription.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
