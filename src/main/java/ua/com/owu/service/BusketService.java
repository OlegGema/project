package ua.com.owu.service;

import ua.com.owu.entity.Busket;
import ua.com.owu.entity.Product;

import java.util.List;

public interface BusketService {
    void add(Busket busket);
    void delete(int id);
    List<Product>usersProd(int id);
}
