package ua.com.owu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.owu.dao.ProductDAO;
import ua.com.owu.entity.Product;
import ua.com.owu.service.ProductService;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductDAO dao;

    @Override
    public void save(Product product) {
        dao.save(product);
    }

    @Override
    public void findByName(String productName) {
        dao.findByProductName(productName);
    }

    @Override
    public Product findOne(int id) {
       return dao.findOne(id);
    }

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public Product findByProductType(String prodcutType) {
        return dao.findByProductType(prodcutType);
    }

    public void deleteProd(int id){
        dao.delete(id);
    }
}
