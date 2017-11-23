package ua.com.owu.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.owu.entity.Busket;
import ua.com.owu.entity.Item;

import java.util.List;


public interface ItemDAO extends JpaRepository<Item,Integer> {
    @Query("from Item  where busket=:busket")
    List<Item> items(@Param("busket")Busket id);

    @Query("update Item set quantity=:quantity where itemId=:id")
    @Modifying
    void updateQuantity(@Param("quantity")int quantity,@Param("id")int id);

}
