package com.foodexpirationservice;


import com.foodexpirationservice.persistence.CleanMasterArray;
import com.foodexpirationservice.persistence.CreateMasterArray;
import com.foodexpirationservice.persistence.CreateWebSiteDataDataBase;
import org.apache.log4j.Logger;

import java.util.List;

/**
 ** * The FoodExpirationService program implements a rest service that
 *    displays food categories, food items, and expiration to the standard output.
 *
 * @authors April Albaugh, Sue Hundt, Heather Hollister
 * @version 1.0
 * @since   2017-04-12
 * Main Controller for Jsoup processing.  Three steps, get the data with Jsoup, clean the data
 * with different methods and finally store the data in the webSiteData1 table in foodexpiration
 * database.
 */

public class JsoupController {


    public static void main(String[] args) {


        /**
         * Use instance of CreateMasterArray class to get data
         */
        CreateMasterArray newMasterArray = new CreateMasterArray();
        List<Object> master;
        master = newMasterArray.CreateMaster();


        /**
         * Use instance of CleanMasterArray class to clean data
         */
        List<String> cleanedMaster;
        CleanMasterArray cleaner = new CleanMasterArray();
        cleanedMaster = cleaner.cleanExtraWords(master);


        /**
         * Use Array returned from CleanMasterArray and instance of
         * CreateWebSiteDataDataBase to update database
         */
        CreateWebSiteDataDataBase newUpdate = new CreateWebSiteDataDataBase();
        newUpdate.ProcessCleanMasterArray(cleanedMaster);

    }
}