package com.foodexpirationservice.persistence;

import com.foodexpirationservice.entity.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by amatheia
 */
public class ItemDaoTest {

    ItemDao dao;

    @Before
    public void setup() {
        dao = new ItemDao();
    }

    @Test
    public void getAllItems() throws Exception {
        List<Item> products = dao.getAllItems();
        assertTrue(products.size() > 0);
    }

    @Test
    public void getCategory() throws Exception {
        final Integer id = 10;
        Item item = dao.getItem(id);
        assertEquals("Expected Buttermilk", "Buttermilk", item.getItemName());
    }

    @Test
    public void getItemsByCategory() throws Exception {
        int id = 1;
        List<Item> items = dao.getItemsByCategory(id);
        assertTrue(items.size() > 0);
    }

    @Test
    public void getItemName() throws Exception {
        String name = "Buttermilk";
        Item item = dao.getItemName(name);
        assertEquals("Expected Buttermilk", "Buttermilk", item.getItemName());
    }

}