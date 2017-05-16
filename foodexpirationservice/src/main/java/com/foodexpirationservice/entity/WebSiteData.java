package com.foodexpirationservice.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 ** * The FoodExpirationService program implements a rest service that
 * displays food categories, food items, and expiration to the standard output.
 *
 * @authors April Albaugh, Sue Hundt, Heather Hollister
 * @version 1.0
 * @since   2017-04-12
 * Entity for data brought in from the EatByDate.com website and stored in the webSiteData1 table of
 * the foodexpiration database.
 */
@Entity(name = "webSiteData1")
public class WebSiteData {


    /**
     *  data_id - Class variable to hold record unique ID number.  Auto-increment
     *  Annotated for use with Hibernate
     */
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "data_id")
    private int dataId;

    /**
     *  category_name - Class variable to hold category name
     *  Annotated for use with Hibernate
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     *  item_name  - Class variable to hold item number
     *  Annotated for use with Hibernate
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     *  field1 - Class variable to hold misc string data -
     *  Annotated for use with Hibernate
     */
    @Column(name = "field1")
    private String field1;


    /**
     *  field2 - Class variable to hold misc string data -
     *  Annotated for use with Hibernate
     */
    @Column(name = "field2")
    private String field2;

    /**
     *  Default Class constructor-
     *
     */
    public WebSiteData() {
    }

    /**
     *  Parameterized constructor -
     *
     */
    public WebSiteData(String categoryName, String itemName, String field1, String field2) {
        super();
        this.categoryName = categoryName;
        this.itemName = itemName;
        this.field1 = field1;
        this.field2 = field2;
    }

    /**
     * GetDataId
     * @return int dataId
     */
    public int getDataId() {
        return dataId;
    }

    /**
     * Set dataId
     * @param dataId
     */
    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    /**
     * Get Cstegory Name
     * @return
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Set Category Name
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /* *
    * Get Item Name
    * @return
    */
    public String getItemName() {
        return itemName;
    }

    /**
     * Set Item name
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Get field1
     * @return
     */
    public String getField1() {
        return field1;
    }

    /**
     * Set field1
     * @param field1
     */
    public void setField1(String field1) {
        this.field1 = field1;
    }

    /**
     *  Get field2
     * @return
     */
    public String getField2() {
        return field2;
    }

    /**
     * Set field2
     * @param field2
     */
    public void setField2(String field2) {
        this.field2 = field2;
    }

    /**
     * Get toString
     * @return
     */
    @Override
    public String toString() {
        return "WebSiteData{" +
                "dataId=" + dataId +
                ", categoryName='" + categoryName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                '}';
    }
}
