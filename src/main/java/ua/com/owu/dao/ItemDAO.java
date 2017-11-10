package ua.com.owu.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.owu.entity.Busket;
import ua.com.owu.entity.Item;

import java.util.List;


public interface ItemDAO extends JpaRepository<Item,Integer> {
    @Query("from Item  where busket=:busket")
    List<Item> items(@Param("busket")Busket id);
}
