package ua.com.owu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.owu.entity.Product;
import ua.com.owu.entity.User;

public interface ProductDAO extends JpaRepository<Product,Integer> {
    @Query("from Product p where p.productName=:productName")
    Product findByProductName(@Param("productName")String productName);

    @Query("from Product p where p.productType=:productType")
    Product findByProductType(@Param("productType")String productType);


}
