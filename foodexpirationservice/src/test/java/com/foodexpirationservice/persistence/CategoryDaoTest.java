package com.foodexpirationservice.persistence;

import com.foodexpirationservice.entity.Category;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by amatheia.
 */
public class CategoryDaoTest {

    CategoryDao dao;

    @Before
    public void setup() {
        dao = new CategoryDao();
    }

    @Test
    public void getAllCategories() throws Exception {
        List<Category> categories = dao.getAllCategories();
        assertTrue(categories.size() > 0);
    }

    @Test
    public void getCategory() throws Exception {
        final Integer id = 1;
        Category category = dao.getCategory(id);
        assertEquals("Expected Dairy", "Dairy", category.getCategoryName());
    }

    @Test
    public void getCategoryName() throws Exception {
        String name = "Dairy";
        Category category = dao.getCategoryName(name);
        assertEquals("Expected Dairy", "Dairy", category.getCategoryName());
    }

}