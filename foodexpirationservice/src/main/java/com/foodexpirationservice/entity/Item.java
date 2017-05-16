package com.foodexpirationservice.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent an item.
 *
 * @author amatheia
 */
@Entity (name = "item")
public class Item {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "item_id")
    private int itemId;

    @Column(name="category_id")
    private int categoryId;

    @Column(name="item_name")
    private String itemName;

    @Column(name="expiration_time")
    private String expirationTime;

    /**
     * Instantiates a new Item.
     */
    public Item() {
    }

    /**
     * Instantiates a new Item.
     *
     * @param itemId    the item id
     * @param categoryId   the category id
     * @param itemName  the item name
     * @param expirationTime    the expiration time
     */
    public Item(int itemId, int categoryId, String itemName, String expirationTime) {
        this.itemId = itemId;
        this.categoryId = categoryId;
        this.itemName = itemName;
        this.expirationTime = expirationTime;
    }

    /**
     * Gets item id.
     *
     * @return the item id
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Sets item id.
     *
     * @param itemId the item id
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * Gets category id.
     *
     * @return the category id
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Sets category id.
     *
     * @param categoryId the category id
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Gets item name.
     *
     * @return the item name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Sets item name.
     *
     * @param itemName the item name
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Gets expiration date.
     *
     * @return the expiration date
     */
    public String getExpirationTime() {
        return expirationTime;
    }

    /**
     * Sets expiration date.
     *
     * @param expirationTime the expiration date
     */
    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public String toString() {
        return "{" +
                "itemId='" + itemId +
                ", categoryId=" + categoryId +
                ", itemName=" + itemName +
                ", expirationTime=" + expirationTime +
                '}';
    }

}
