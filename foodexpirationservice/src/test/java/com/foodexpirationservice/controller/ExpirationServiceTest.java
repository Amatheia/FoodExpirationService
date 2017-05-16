package com.foodexpirationservice.controller;

import org.apache.log4j.Logger;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * The FoodExpirationService program implements a rest service that
 * displays food categories, food items, and expiration to the standard output.
 *
 * @authors April Albaugh, Sue Hundt, Heather Hollister
 * @version 1.0
 * @since   2017-04-12
 */
public class ExpirationServiceTest {

    private final Logger log = Logger.getLogger(this.getClass());

    @Test
    public void testGetCategories() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                    client.target("http://localhost:8080/expiration/categories");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("[{\"categoryName\":\"Dairy\",\"categoryId\":1},{\"categoryName\":\"Meat\",\"categoryId\":2},{\"categoryName\":\"Fruit\",\"categoryId\":3},{\"categoryName\":\"Vegetables\",\"categoryId\":4}]", response);
    }

    @Test
    public void testGetItems() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://localhost:8080/expiration/items");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertNotEquals("???", response);
    }

    @Test
    public void getItemsByCategory() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://localhost:8080/expiration/itemsByCategory?categoryId=1");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertNotEquals("Milk", response);
    }

    @Test
    public void getItemsByName() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://localhost:8080/expiration/itemsByName?itemName=Milk");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("[{\"itemId\":14,\"itemName\":\"Milk\",\"expirationTime\":\"5-7 Days\",\"categoryId\":1}]", response);
    }

}