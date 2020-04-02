import Menu.CaseMenu;
import entities.Item;
import entities.Store;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reader.Reader;
import sorting.Sorting;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*Создать стрим entities.Item и:
        − проверить, есть ли товары, дороже 500;
        − Найти товары с максимальным и минимальным количеством единиц на складе
        − Отфильтровать товары с единственным магазином
        − Отсортировать товары по цене и количеству
        − Получить список магазинов
        − Напечатать информацию о магазинах, используя foreach
        − Получить список магазинов без дубликатов
        a. ClassA - entities.Item с полями:
        o String name
        o Int price
        o Int count
        o List<entities.Store> stores
        b. ClassB – entities.Store с полями:
        o String name
        o List<entities.Item> items
        o List<String> feedbackList

 */
public class Main {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Store> stores = new ArrayList<>();

        Reader.readItems(items);
        Reader.readStores(stores,items);

        Supplier<Stream<Item>> itemSupply = items::stream;
        Scanner in = new Scanner(System.in);

        CaseMenu menu = new CaseMenu(in);
        menu.start(itemSupply);
    }
}
