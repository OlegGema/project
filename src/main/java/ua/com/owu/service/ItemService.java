package ua.com.owu.service;

import org.springframework.data.repository.query.Param;
import ua.com.owu.entity.Busket;
import ua.com.owu.entity.Item;


import java.util.List;

public interface ItemService {
    void save(Item item);
    Item findOne(int id);
    List<Item>findAll();
    void delete(int id);
    List<Item>Items(Busket id);
    void updateQuantity(int quantity,int id);

}
