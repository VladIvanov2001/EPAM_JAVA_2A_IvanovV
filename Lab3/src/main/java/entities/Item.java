package entities;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;
/* a. ClassA - entities.Item с полями:
                o String name
                o Int price
                o Int count
                o List<entities.Store> stores
*/
public class Item {
    private String name;
    private Integer price;
    private Integer count;
    private List<Store> stores;

    public Item() {
        this.stores = new LinkedList<>();
    }

    public Item(String name, Integer price, Integer count) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.stores = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getCount() {
        return count;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(Store store) {
        this.stores.add(store);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Item.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("price=" + price)
                .add("count=" + count)
                .add("stores=" + stores.size())
                .toString();
    }
}
