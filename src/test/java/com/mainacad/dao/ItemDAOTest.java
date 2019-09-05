package com.mainacad.dao;

import com.mainacad.config.SpringConfig;
import com.mainacad.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(SpringConfig.class)
@ActiveProfiles("test")
class ItemDAOTest {

    @Autowired
    ItemDAO itemDAO;

    @Test
    void saveOrUpdate() {
        Item item = new Item();
        item.setArticle("123445");
        item.setInitPrice(1233);
        item.setName("Perf");
        item.setPrice(1000);

        List<Item> items = itemDAO.findAll();
        assertTrue(items.isEmpty());
    }
}