package com.foodexpirationservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.foodexpirationservice.entity.Category;
import com.foodexpirationservice.entity.Item;
import com.foodexpirationservice.persistence.CategoryDao;
import com.foodexpirationservice.persistence.ItemDao;
import com.foodexpirationservice.error.ServiceError;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The FoodExpirationService program implements a rest service that
 * displays food categories, food items, and expiration to the standard output.
 *
 * @authors April Albaugh, Sue Hundt, Heather Hollister
 * @version 1.0
 * @since   2017-04-12
 */
@Path("/expiration")
public class ExpirationService {

    private final Logger log = Logger.getLogger(this.getClass());

    CategoryDao dao = new CategoryDao();
    ItemDao daoItem = new ItemDao();


    /**
     * This method is used to return all categories
     * in JSON.
     * @return method This returns all categories.
     */
    @GET
    @Path("/categories")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Category> getCategories() throws JsonProcessingException {
        log.info("Categories: " + dao.getAllCategories());
        return dao.getAllCategories();
    }

    /**
     * This method is used to return all items
     * in JSON.
     * @return method This returns all items.
     */
    @GET
    @Path("/items")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Item> getItems() throws JsonProcessingException {
        log.info("Categories: " + daoItem.getAllItems());
        return daoItem.getAllItems();
    }

    /**
     * This method is used to return all items
     * by category id in JSON using the request URI query parameter.
     * @param categoryId The categoryId
     * @return method This returns all items by category.
     */
    @GET
    @Path("/itemsByCategory")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Item> getItemsByCategory(@QueryParam("categoryId") int categoryId) {
        log.info("Categories: " + daoItem.getItemsByCategory(categoryId));
        return daoItem.getItemsByCategory(categoryId);
    }

    /**
     * This method is used to return a single item
     * by item name in JSON using the request URI query parameter.
     * @param itemName  The item name
     * @return method This returns an item by name.
     */
    @GET
    @Path("/itemsByName")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Item> getItemsByName(@QueryParam("itemName") String itemName) {
        log.info("Item: " + daoItem.getItemsByName(itemName));
        return daoItem.getItemsByName(itemName);
    }

    /**
     * This method is used to return a single category
     * by category name in JSON using the request URI query parameter.
     * @param categoryName  The category name
     * @return method This returns a category by name.
     */
    @GET
    @Path("/categoriesByName")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCategoriesByName(@QueryParam("categoryName") String categoryName) {
        log.info("Category: " + dao.getCategoryName(categoryName));
        Category catName = dao.getCategoryName(categoryName);
        return Response.status(200).entity(catName).build();
    }

    /**
     * This method is used to return the expiration date based on
     * user input using form parameter.
     * @param item The item
     * @return Response This returns the response.
     */
    @POST
    @Path("/expirationDate")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    public Response getExpirationDate(@FormParam("itemList") String item) {
        String expiration;
        Item product;
        product = daoItem.getItemName(item);
        expiration = product.getExpirationTime();
        String output;

       try {
            output = "<p>Item: " + item + "</p>" + "<p>Expiration: " + expiration + "</p>";
        } catch (Exception e) {
            ServiceError error = new ServiceError();
            String message = error.getResponseErrorMessage();
            return Response.status(500).entity(message).build();
        }
        log.info(output);
        return Response.status(200).entity(output).build();
    }

}
