package reader;

import entities.Item;
import entities.Store;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Reader {
    static Logger logger = LogManager.getLogger();
    public static void readItems(ArrayList<Item> items){
        try(BufferedReader reader = new BufferedReader(new FileReader("data/items.txt"))){
            String buffer;
            while((buffer = reader.readLine()) != null){
                StringTokenizer tokenizer = new StringTokenizer(buffer, "-");
                String name = tokenizer.nextToken();
                int price = Integer.parseInt(tokenizer.nextToken());
                int count = Integer.parseInt(tokenizer.nextToken());
                items.add(new Item(name,price,count));
            }
        }catch (IOException e){
            logger.error(e);
        }
    }

    public static void readStores(ArrayList<Store> stores, ArrayList<Item> items){
        try (BufferedReader reader = new BufferedReader(new FileReader("data/store.txt"))){
            String buffer;
            while((buffer = reader.readLine()) != null){
                Store store = new Store();
                StringTokenizer tokenizer = new StringTokenizer(buffer, "-");
                store.setName(tokenizer.nextToken());
                store.addFeedback(tokenizer.nextToken());

                while(tokenizer.hasMoreElements()){
                    Item item = new Item();
                    String itemName = tokenizer.nextToken();

                    for (Item tmpItem : items) {             //Чтобы в айтемы добавить магазин, а в стор добавить айтем
                        if(tmpItem.getName().equals(itemName)){
                            item = tmpItem;
                            item.setStores(store);
                            store.setItems(item);
                        }
                    }
                }

                stores.add(store);
            }
        }catch (IOException e){
            logger.error(e);
        }
    }
}


