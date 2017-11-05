package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.owu.dao.BusketDAO;
import ua.com.owu.entity.Busket;
import ua.com.owu.entity.Item;
import ua.com.owu.entity.Product;
import ua.com.owu.entity.User;
import ua.com.owu.service.BusketService;

import java.util.List;

@Service
@Transactional
public class BusketServiceImpl implements BusketService {
    @Autowired
    BusketDAO dao;
    @Override
    public void add(Busket busket) {
        dao.save(busket);
    }




    @Override
    public void delete(int id) {
        dao.delete(id);
    }



    @Override
    public List<Product> usersProd(int id) {
         return dao.findUserProducts(id);

    }


}
