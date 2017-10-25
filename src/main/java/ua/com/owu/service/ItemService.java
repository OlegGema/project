package ua.com.owu.service;

import ua.com.owu.entity.Item;


import java.util.List;

public interface ItemService {
    void save(Item item);
    Item findOne(int id);
    List<Item>findAll();
    void delete(int id);

}
