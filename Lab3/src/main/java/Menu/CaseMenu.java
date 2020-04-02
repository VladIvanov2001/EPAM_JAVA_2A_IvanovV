package Menu;
import entities.Item;
import sorting.Sorting;

import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;


public class CaseMenu {
    private final Scanner in;

    public CaseMenu(Scanner scanner) {
        this.in = scanner;
    }
    public void printMenu(){
        System.out.println("Возможности:\n 1) проверить, есть ли товары, дороже 500; \n 2) Найти товары с максимальным количеством единиц на складе; " +
                            "\n 3) Найти товары с минимальным количеством единиц на складе; \n 4) Отфильтровать товары с единственным магазином \n 5) Отсортировать товары по цене \n " +
                            "6) Отсортировать товары по количеству \n 7) Получить список магазинов \n " +
                            "8)Напечатать информацию о магазинах, используя foreach \n 9)Получить список магазинов без дубликатов \n 10) Выход");
    }
    public void start(Supplier<Stream<Item>> itemSupply) {
        if(this.in != null) {
            int choice;
            do {
                printMenu();
                choice = this.in.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println(Sorting.overFiveHundred(itemSupply));
                        break;
                    case 2:
                        System.out.println(Sorting.maxCount(itemSupply));
                        break;
                    case 3:
                        System.out.println(Sorting.minCount(itemSupply));
                        break;
                    case 4:
                        System.out.println(Sorting.oneStore(itemSupply));
                        break;
                    case 5:
                        System.out.println(Sorting.sortPrice(itemSupply));
                        break;
                    case 6:
                        System.out.println(Sorting.sortByCount(itemSupply));
                        break;
                    case 7:
                        Sorting.getStores(itemSupply).forEach(System.out::println);
                        break;
                    case 8:
                        break;
                    case 9:
                        Sorting.getDistinctStores(itemSupply).forEach(System.out::println);
                        break;
                }
            } while (choice != 10);
        }
    }
}

