package km;
/* Фаил для ввода данных таблицу в коде */
public class inf {
    private String category;

    private String description;

    private String date;

    private String sum;

    public inf(String category, String description, String date, String sum) {
        this.category = category;
        this.description = description;
        this.date = date;
        this.sum = sum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void seDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}

