package com.foodexpirationservice.persistence;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * ** * The FoodExpirationService program implements a rest service that
 * displays food categories, food items, and expiration to the standard output.
 *
 * @authors April Albaugh, Sue Hundt, Heather Hollister
 * @version 1.0
 * @since   2017-04-12
 * Class strips unneeded words and phrases from the data scrapped from
 * the EatByDate.com website using Jsoup
 * Created for Team Project on 4/9/17.
 */
public class CleanMasterArray {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Method takes in the List containing urls and <td> items retrieved from
     * EatByDate.com website.  Strips out extra words
     * @param master
     * @return
     */
    public List<String> cleanExtraWords(List<Object> master) {

        /**
         * Local variable to hold incoming List
         */
        List<String> cleanStrings = new ArrayList<String>();

        /**
         * Process each element to remove unneeded words
         */
        for (Object phrase : master) {

            String version1 = phrase.toString();

            String version2 = version1.replace(" lasts for", "");

            String version3 = version2.replace(" last for", "");

            String version4 = version3.replace("lasts", "");

            String finalString = version4.replace(" until", "");

            cleanStrings.add(finalString);

        }

        log.info("Strings have been cleared of lasts for, last for, etc.  In CleanMasterArray");


        /**
         * Return a list of cleaned phrases
         */
        return cleanStrings;
    }
}

