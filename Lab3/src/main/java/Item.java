import java.util.List;

public class Item {
    private String name;
    private int price;
    private int count;
    private List<Store> stores;

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public List<Store> getStores() {
        return stores;
    }
}
