package ru.sinys.dao;

import org.springframework.data.repository.CrudRepository;
import ru.sinys.model.Item;

import java.util.List;

public interface ItemDao extends CrudRepository<Item, Long> {

    List<Item> findByArticle(String article);

    List<Item> findAllByOrderByArticle();
}
