package ua.com.owu.service;

import ua.com.owu.entity.Busket;
import ua.com.owu.entity.Product;

import java.util.List;

public interface BusketService {
    void add(Busket busket);
//    List<Busket>findUserProducts(int idOfUser);
    void delete(int id);
//    void addProduct(Busket busketId,Product productId);
    List<Product>usersProd(int id);
}
