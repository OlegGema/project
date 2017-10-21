package ua.com.owu.service;

import ua.com.owu.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);
    void findByName(String productName);
    void deleteProd(int id);
    Product findOne(int id);
    List<Product> findAll();
    Product findByProductType(String prodcutType);
}
