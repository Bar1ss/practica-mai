package km;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException { //окно 
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Учёт расходов");
        Image anotherIcon = new Image("file:C:\\Users\\User\\Desktop\\Уник\\программирование\\Практика\\practica-main\\app\\demo\\src\\main\\java\\km\\HavnyShishi.png");
        stage.getIcons().add(anotherIcon);

         TextField textField = new TextField();
        Button saveButton = new Button("Save Data");

        VBox root = new VBox(10, textField, saveButton);
        @SuppressWarnings("unused")
        Scene scene = new Scene(root, 300, 200);

        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
      
} 