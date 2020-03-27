import java.util.List;

public class Store {
    private String name;
    private List<Item> items;
    private List<String> feedbackList;

    public Store(String name, List<Item> items, List<String>feedbackList){
        this.name = name;
        this.items = items;
        this.feedbackList = feedbackList;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<String> getFeedbackList() {
        return feedbackList;
    }
}
