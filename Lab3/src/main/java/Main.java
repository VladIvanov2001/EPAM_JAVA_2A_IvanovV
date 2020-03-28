import java.util.ArrayList;
/*Создать стрим Item и:
        − проверить, есть ли товары, дороже 500;
        − Найти товары с максимальным и минимальным количеством единиц на складе
        − Отфильтровать товары с единственным магазином
        − Отсортировать товары по цене и количеству
        − Получить список магазинов
        − Напечатать информацию о магазинах, используя foreach
        − Получить список магазинов без дубликатов
        a. ClassA - Item с полями:
        o String name
        o Int price
        o Int count
        o List<Store> stores
        b. ClassB – Store с полями:
        o String name
        o List<Item> items
        o List<String> feedbackList

 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Store> stores = new ArrayList<>();
    }
    public static void printItem(Item item) {
        System.out.println(item.getName() + " " + item.getPrice() + " " + item.getCount());
        item.getStores().forEach(s -> System.out.println("  " + s.getItems() + " " + s.getFeedbackList() + s.getName()));
    }

    public static void printStore(Store store) {
        System.out.println(store.getItems() + " " + store.getFeedbackList() + store.getName());
        store.getItems().forEach(item -> System.out.println(item.getName() + " " + item.getPrice() + " " + item.getCount()));
    }
}
