package km;

public class inf {
    private String category;

    private String description;

    private int date;

    private int sum;

    public inf(String category, String description, int date, int sum) {
        this.category = category;
        this.description = description;
        this.date = date;
        this.sum = sum;
    }

    public inf() {
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

    public int getDate() {
        return date;
    }

    public void setDate(int password) {
     //   this.date = date;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}

