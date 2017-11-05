package ua.com.owu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.owu.entity.Busket;
import ua.com.owu.entity.Item;
import ua.com.owu.entity.Product;
import ua.com.owu.entity.User;

public interface ItemDAO extends JpaRepository<Item,Integer> {
    @Modifying
    @Query("update Item set quantity=:quantity where itemId=:id")
    void updateQuantity(@Param("quantity")int quantity,@Param("id")int itemId);
}
