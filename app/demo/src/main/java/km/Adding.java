package km;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Adding {
    private final StringProperty category;
    private final StringProperty sum;
    private final String date;
    private final StringProperty description;
    private final SimpleIntegerProperty Id;
    public Adding() {
        this(null,null, null, null, 0);
    }

    // public Adding (String category, String sum, String date, String description, int Id) {
    //     this.category = new SimpleStringProperty(category);
    //     this.sum = new SimpleStringProperty(sum);
    //     this.date = date;
    //     this.description = new SimpleStringProperty(description);
    //     this.Id = new SimpleIntegerProperty(Id);
    // }
    
    public Adding(String category, String sum, String date, String description, int Id){
        this.category = new SimpleStringProperty(category);
        this.sum = new SimpleStringProperty(sum);
        this.date = new SimpleStringProperty(new SimpleDateFormat("dd-MM-yyyy").format(new Date())).getValue();
        this.description = new SimpleStringProperty(description);
        this.Id = new SimpleIntegerProperty(Id);
    }

    //Геттеры сеттеры
    public String getCategory() {
        return category.get();
    }
    public void setCategory(String category) {
        this.category.set(category);
    }
    public StringProperty categoryProperty() {
        return category;
    }

    public String getSum() {
        return sum.get();
    }
    public void setSum(String sum) {
        this.sum.set(sum);
    }
    public StringProperty sumProperty() {
        return sum;
    }

    public String getDescription() {
        return description.get();
    }
    public void setDescription(String description) {
        this.description.set(description);
    }
    public StringProperty descriptionProperty() {
        return description;
    }

    public String getDate() {
        return date;
    }
    public String setDate() {
        return date;
    }
    public String dateProperty() {
        return date;
    }

    public int getId() {
        return Id.get();
    }
    public void setId(int Id) {
        this.Id.set(Id);
    }
    public IntegerProperty IdProperty() {
        return Id;
    }

}
