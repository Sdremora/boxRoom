package ru.sinys.model.Service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.sinys.dao.ItemDao;
import ru.sinys.model.Item;

import java.util.List;

public class ItemService {

    @Autowired
    private ItemDao itemDao;

    public List<Item> getAllItem(){
        return itemDao.findAllByOrderByArticle();
    }

    public Item getItem(String article){
        List<Item> itemList = itemDao.findByArticle(article);
        if (itemList.size() == 1) {
            return itemList.get(0);
        }
        return null;
    }


    public void deleteItem(Item item){
        itemDao.delete(item);
    }

    public void deleteItem(String article) {
        Item item = getItem(article);
        if (item != null)
            deleteItem(item);
    }

    public void addItem(Item item) {
        itemDao.save(item);
    }
}
