package com.foodexpirationservice.persistence;

import com.foodexpirationservice.entity.Category;
import com.foodexpirationservice.HTMLParser;
import com.foodexpirationservice.ItemParser;
import org.apache.commons.validator.routines.UrlValidator;
import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static java.lang.System.out;

/** The FoodExpirationService program implements a rest service that
 * displays food categories, food items, and expiration to the standard output.
 *
 * @authors April Albaugh, Sue Hundt, Heather Hollister
 * @version 1.0
 * @since   2017-04-12
 * Class takes raw data coming in from Jsoup scrape of website
 * the EatByDate.com website using Jsoup. Identifies the valid urls, calls ItemParser on each
 * valid url and processes <td> items returned from ItemParser
 */
public class CreateMasterArray {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Method creates an ArrayList of Arrays that contain valid data from EatByDate.com
     * @return a List of valid urls
     */
    public List<Object> CreateMaster() {

        /**
         * Local instance of Dao variable to hold list of current categories in the category table in
         * the foodexpiration database
         */
        List<Category> allCatList = new ArrayList<Category>();
        CategoryDao newCatDao = new CategoryDao();

        /**
         * Local variable set created to hold data returned by initial parsing of the main eatbydate.com index page
         * HTML Parser gets all HTML from main eatbydate.com index page and find href links
         */
        Set newSet;
        HTMLParser newParsedData = new HTMLParser();

        /**
         * Local ArrayList to hold data that has been inspected.
         * This arraylist is returned to the calling class
         */
        List<Object> masterArray = new ArrayList<Object>();


        /**
         *   Local ItemParser object to look for data found after a valid url is found
         */
        ItemParser parser = new ItemParser();

        /**
         * Use Dao method to retrieve list of categories
         */
        allCatList = newCatDao.getAllCategories();


        /**
         * Run HTMLParser method to get the hrefs
         */
        newSet = newParsedData.createSetOfMainPageLinks();

        /**
         * Main for loop that processes data through for each Category (meat, fruit, dairy, vegetables
         */
        for (Category cat : allCatList) {
            String currentCategory = cat.getCategoryName().toLowerCase();

            /**
             *  Process the set: first looking for valid urls (hrefs)
             */
            for (Object hrefParse : newSet) {

                /**
                 * Use UrlValidator Class to identify valid URL
                 */
                String stringHref = (String) hrefParse;
                String[] schemes = {"http", "https"};

                UrlValidator urlValidator = new UrlValidator(schemes);

                Boolean verdict = urlValidator.isValid(stringHref);

                /**
                 * If a valid URL is found (using UrlValidator
                 * verdict = true)
                 */
                if (verdict) {

                    /**
                     *  Local temp array to hold data during inspection process
                     *
                     */
                    ArrayList<String> cleanedArray = new ArrayList<String>();


                    /**
                     * Inspect the url for the current Category we are looking for
                     */
                    if (stringHref.contains(currentCategory)) {


                        /**
                         * Call method on ItemParser instance that will retrieve the table data
                         * found at that url
                         */
                        ArrayList<String> newArray = parser.createMetaDataArrays(hrefParse);

                        /**
                         * Process the table data for the current url
                         */
                        Boolean newItemFound = false;
                        int counter = 0;

                        /**
                         * Step through looking FIRST for word "last" which indicates that a food
                         * is found
                         * SECOND look for values that indicate time (Day, Days, Week, etc.)
                         * Store in local "cleanedArray"
                         */
                        for (String item : newArray) {

                            if (counter == 2) {

                                if (item.contains("Day") || item.contains("Days") || item.contains("Week") || item.contains("Weeks") || item.contains("Month") || item.contains("Months")) {
                                    cleanedArray.add(item);
                                    counter = 0;
                                    newItemFound = false;
                                } else {
                                    counter = 0;
                                    newItemFound = false;
                                }

                            } else if (counter == 1) {
                                cleanedArray.add(item);
                                counter++;

                            } else if (newItemFound) {
                                cleanedArray.add(item);
                                counter = 2;

                            } else if (item.contains("last") || item.contains("lasts")) {
                                cleanedArray.add(cat.getCategoryName());
                                cleanedArray.add(item);
                                counter = 1;
                                newItemFound = true;
                            }
                        }

                        /**
                         * Create and add to local text file
                         */
                        if (cleanedArray.isEmpty()) {
                        } else {
                            String fileName = currentCategory + ".txt";
                            for (Object item : cleanedArray) {
                                try {
                                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
                                    out.print(item);

                                } catch (IOException e) {
                                }
                                out.println(item);
                            }
                            out.close();
                            /**
                             * Add new array to master array
                             */
                            masterArray.add(cleanedArray);

                        }

                    }
                }
            }
        }

        log.info("masterarray has been created.  Size:" + masterArray.size());

        return masterArray;
    }
}