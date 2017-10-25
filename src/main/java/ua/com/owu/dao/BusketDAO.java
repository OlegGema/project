package ua.com.owu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.owu.entity.Busket;
import ua.com.owu.entity.Product;

import java.util.List;

public interface BusketDAO extends JpaRepository<Busket,String> {




    @Query("from Busket product_id where busket_buskteId=:id")
    List<Product>findUserProducts(@Param("id")int id);

    @Modifying
    @Query("delete from Busket where id=:id")
    void delete(@Param("id")int id);
}
