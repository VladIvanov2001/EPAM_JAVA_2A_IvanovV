package sorting;

import entities.Item;
import entities.Store;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
        − проверить, есть ли товары, дороже 500;
        − Найти товары с максимальным и минимальным количеством единиц на складе
        − Отфильтровать товары с единственным магазином
        − Отсортировать товары по цене и количеству
        − Получить список магазинов
        − Напечатать информацию о магазинах, используя foreach
        − Получить список магазинов без дубликатов
*/
public class Sorting {
    public static List<Item> overFiveHundred(Supplier<Stream<Item>> itemSupply){ //дороже 500
        return itemSupply.get().filter(item -> item.getPrice() > 500)
                .peek(item-> System.out.println("items with price over 500: "+item.getName()))
                .collect(Collectors.toList());
    }

    public static Item maxCount(Supplier<Stream<Item>> itemSupply){ //максимальное количество
        Optional<Item> maxCount = Optional.of(itemSupply.get().max(Comparator.comparingInt(Item::getCount)).get());//Возвращает объект
        return maxCount.orElseGet(Item::new);//orElseGet - возвращает новый объект, если не получится вернуть maxCount
    }

    public static Item minCount(Supplier<Stream<Item>> itemSupply){
        Optional<Item> minCount = Optional.of(itemSupply.get().min(Comparator.comparingInt(Item::getCount)).get());
        return minCount.orElseThrow(NullPointerException::new);//Не получается вернуть объект - возвращается эксепшн
    }

    public static List<Item> oneStore(Supplier<Stream<Item>> itemSupply){ //товар с единственным магазином
        return itemSupply.get().filter(item -> item.getStores().size() == 1)
                .collect(Collectors.toList());
    }

    public static List<Item> sortPrice(Supplier<Stream<Item>> itemSupply){//сортировка по цене
        return itemSupply.get().sorted(
                Comparator.comparing(Item::getPrice))
                .collect(Collectors.toList());
    }

    public static List<Item> sortByCount(Supplier<Stream<Item>> itemSupply){//сортировка по количеству
        return itemSupply.get().sorted(
                Comparator.comparing(Item::getCount))
                .collect(Collectors.toList());
    }

    public static ArrayList<Store> getStores(Supplier<Stream<Item>> itemSupply){//список магазинов
        ArrayList<Store> stores = new ArrayList<>();
        itemSupply.get().forEach(item->{
            stores.addAll(item.getStores());
        });
        return stores;
    }

    public static ArrayList<Store> getDistinctStores(Supplier<Stream<Item>> itemSupply){//уникальные магазины
        Stream<Store> storeStream = getStores(itemSupply).stream();
        ArrayList<Store> distinctStore = new ArrayList<>();
        storeStream.distinct().forEach(distinctStore::add);
        storeStream.close();
        return distinctStore;
    }
}
