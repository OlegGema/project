package ua.com.owu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.entity.Item;

public interface ItemDAO extends JpaRepository<Item,Integer> {
}
