package com.foodexpirationservice.persistence;

import com.foodexpirationservice.entity.WebSiteData;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
<<<<<<< HEAD
 ** * The FoodExpirationService program implements a rest service that
 *    displays food categories, food items, and expiration to the standard output.
 *
 * @authors April Albaugh, Sue Hundt, Heather Hollister
 * @version 1.0
 * @since   2017-04-12
 * Test that Tests the methods in the WebSiteDataDao
=======
 * Created by sue.
>>>>>>> a56da0a9b85a7b1d2ffc5be3a9a1e7752eb4b64e
 */
public class WebSiteDataDaoTest extends WebSiteDataDao {
    static Logger log = Logger.getLogger(WebSiteDataDaoTest.class.getName());
    WebSiteDataDao dao;

    @Before
    public void setup() {
        dao = new WebSiteDataDaoTest();
    }

    @Test
    public void testGetAllData() throws Exception {
        List<WebSiteData> webData = dao.getAllData();
        assertTrue(webData.size() > 0);
    }

    @Test
    public void testGetDataByCategory() throws Exception {
        List<WebSiteData> dataByCategory = dao.getDataByCategory("Dairy");
        assertEquals("Data not Found", 524, dataByCategory.size());

    }

    /**
     @Test
     public void testGetItem() throws Exception {
     List<WebSiteData> data = dao.getItem("testitemName");
     assertEquals("Data Not Found", 1, data.size());
     }
     */
    @Test
    public void testAddData() throws Exception {
        int before = dao.getAllData().size();
        String newItemName = "testitemName" + before;
        WebSiteData newData = new WebSiteData("testcategoryName", newItemName, "testfield1", "testfield2");
        dao.addData(newData);
        int after = dao.getAllData().size();
        assertEquals("Data not added correctly", before + 1, after);
    }

}

