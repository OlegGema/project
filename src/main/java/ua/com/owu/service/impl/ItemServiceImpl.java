package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.owu.dao.ItemDAO;
import ua.com.owu.entity.Busket;
import ua.com.owu.entity.Item;
import ua.com.owu.entity.Product;
import ua.com.owu.service.ItemService;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemDAO dao;
    @Override
    public void save(Item item) {
        dao.save(item);
    }

    @Override
    public Item findOne(int id) {
        return dao.findOne(id);
    }

    @Override
    public List<Item> findAll() {
        return dao.findAll();
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public List<Item> Items(Busket id) {
        return dao.items(id);
    }

    @Override
    public void updateQuantity(int quantity, int id) {
        dao.updateQuantity(quantity, id);
    }


}
