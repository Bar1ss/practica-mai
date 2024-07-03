package km;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Jenya {
@FXML
private AnchorPane anchorPane;
@FXML
private ListView list_view, date_list;
@FXML
private TextArea text_area, search_text_field;
@FXML
private Button button_edit, button_new, button_del, button_sw, button_sp, search_button;
@FXML
private Label label_data, label_tod, switch_pose;
private Map<String, String> notes = new HashMap<>();
private Map<String, LocalDate> notesDates = new HashMap<>();
public static int style = 0;
@FXML
public void getTodo() {
String selectedTodo = (String) list_view.getSelectionModel().getSelectedItem();
if (selectedTodo != null) {
String note = notes.get(selectedTodo);
if (note != null) {
text_area.setText(note);
}
}
}
@FXML
private void deleteButtonClicked() {
String selectedTodo = (String) list_view.getSelectionModel().getSelectedItem();
if (selectedTodo != null) {
notes.remove(selectedTodo);
notesDates.remove(selectedTodo); // удаляем дату записки
saveNotesToFile();
updateListView();
updateDateList();
}
}
@FXML
private void addNewButtonClicked() {
String newTodo = text_area.getText();
if (!newTodo.isEmpty()) {
list_view.getItems().add(newTodo);
text_area.clear();
}
}
    @FXML
    private void saveButtonClicked() {
        String title = (String) list_view.getSelectionModel().getSelectedItem();
        String note = text_area.getText();
        if (title != null && !title.isEmpty() && note != null && !note.isEmpty()) {
            notes.put(title, note);
            notesDates.put(title, java.time.LocalDate.now()); // сохраняем дату для записки
            saveNotesToFile();
            updateListView();
            updateDateList();
            }
    }
@FXML
private void updateListView() {
list_view.getItems().clear();
list_view.getItems().addAll(notes.keySet());
text_area.clear();
}
@FXML
private void updateDateList() {
date_list.getItems().clear();
for (String todo : notes.keySet()) {
date_list.getItems().add(notesDates.get(todo));
}
}
    @FXML
    private void saveNotesToFile() {
        try {
            Properties props = new Properties();
            for (Map.Entry<String, String> entry : notes.entrySet()) {
                String title = entry.getKey();
                String note = entry.getValue();
                LocalDate date = notesDates.get(title);
                props.setProperty(title, note + "|" + date.toString()); // используйте toString() для конвертации даты в строку
            }
            File file = new File("notes.properties");
            FileOutputStream out = new FileOutputStream(file);
            props.store(out, "Saved notes");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
@FXML
private void loadNotesFromFile() {
try {
Properties props = new Properties();
File file = new File("notes.properties");

if (file.exists()) {
FileInputStream in = new FileInputStream(file);
props.load(in);
in.close();

for (Map.Entry<Object, Object> entry : props.entrySet()) {
String title = (String) entry.getKey();
String[] parts = ((String) entry.getValue()).split("\\|");
String note = parts[0];
LocalDate date = LocalDate.parse(parts[1]);

notes.put(title, note);
notesDates.put(title, date);
}
}
} catch (IOException e) {
e.printStackTrace();
}
}
@FXML
public void initialize() {
loadNotesFromFile();
updateListView();
updateDateList();
}}