package com.foodexpirationservice.persistence;

import com.foodexpirationservice.entity.Category;
import com.foodexpirationservice.entity.WebSiteData;
import org.apache.log4j.Logger;

import java.util.List;

/** The FoodExpirationService program implements a rest service that
 * displays food categories, food items, and expiration to the standard output.
 *
 * @authors April Albaugh, Sue Hundt, Heather Hollister
 * @version 1.0
 * @since   2017-04-12
 * Class takes cleaned data coming in from the CleanMasterArray and puts it in the database
 * file WebSiteData1
 *
 */
public class CreateWebSiteDataDataBase {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Method takes in Array and assigns data element to proper database field
     * Then writes to database table
     * @param CleanMasterArray
     */
    public void ProcessCleanMasterArray(List<String> CleanMasterArray){

        /**
         * Local variables needed to process records
         */
        String dataName = "";
        String field1 = "";
        String field2 = "";

        Boolean itemFound = false;
        Boolean needField1 = false;
        Boolean needField2 = false;
        Boolean readyToWrite = false;

        /**
         * Local instance of Category Dao to retrieve Category Names
         */
        List<Category> allCatList;
        CategoryDao newCatDao = new CategoryDao();


        /**
         * Use Category Dao method to get category list
         */
        allCatList = newCatDao.getAllCategories();

        /**
         * Run the process each time for each category
         */
        for (Category cat : allCatList) {
            String catNameCategory = cat.getCategoryName();

            /**
             * For loop to process each cleaned string
             */
            for (String dataItem : CleanMasterArray) {

                /**
                 * FIRST STEP - split String using commas and remove beginning anf ending spaces
                 */
                String[] singleItem = dataItem.trim().split("\\s*,\\s*");

                /**
                 * Inspect each element split from the main string
                 */
                for (String focusItem : singleItem) {

                    /**
                     * Remove square brackets
                     */
                    String version1 = focusItem.replace("]", "");
                    focusItem = version1.replace("[", "");


                    /**
                     * Steps to determine which type of field the current element is
                     * First look for the category word, Second process the item name Third the field1 & field2 elements
                     * Lastly when ready to write, add record
                     */
                    if (readyToWrite) {

                        log.info("new item added: " + catNameCategory + "----" + dataName + "---" + field1 + "----" + field2);
                        WebSiteData newData = new WebSiteData(catNameCategory, dataName, field1, field2);
                        WebSiteDataDao dao = new WebSiteDataDao();
                        try {
                            dao.addData(newData);
                        } catch (Exception ex) {
                            log.error("Error in adding new record: " + ex);
                        }
                        readyToWrite = false;

                        dataName = "";
                        field1 = "";
                        field2 = "";

                    }

                    if (needField2) {
                        if (focusItem == "Dairy" || dataItem == "Meat" || dataItem == "Fruit" || dataItem == "Vegetables") {

                            WebSiteData newData = new WebSiteData(catNameCategory, dataName, field1, field2);
                            WebSiteDataDao dao = new WebSiteDataDao();
                            try {
                                dao.addData(newData);
                            } catch (Exception ex) {

                            }
                            dataName = "";
                            field1 = "";
                            field2 = "";

                        } else {
                            field2 = focusItem;
                            needField2 = false;
                            readyToWrite = true;

                        }

                    }

                    if (needField1) {
                        field1 = focusItem;
                        needField2 = true;
                        needField1 = false;
                    }

                    if (itemFound) {
                        dataName = focusItem;
                        needField1 = true;
                        itemFound = false;
                    }

                    if (focusItem.contains(catNameCategory)) {

                        itemFound = true;
                    }
                }
            }
        }
    }
}

