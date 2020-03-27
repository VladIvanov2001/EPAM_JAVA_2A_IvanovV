import java.util.List;

public class Item {
    private String name;
    private int price;
    private int count;
    private List<Store> stores;

    public Item(String name, int price, int count){
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }
}
