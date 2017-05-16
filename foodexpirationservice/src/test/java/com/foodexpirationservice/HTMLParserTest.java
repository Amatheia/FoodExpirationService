package com.foodexpirationservice;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

/**
 ** * The FoodExpirationService program implements a rest service that
 *    displays food categories, food items, and expiration to the standard output.
 *
 * @authors April Albaugh, Sue Hundt, Heather Hollister
 * @version 1.0
 * @since   2017-04-12
 * Test that Tests the method in the HTML Parser working with the EatByDate.com website with Jsoup
 */
public class HTMLParserTest {

    Set testSet = new TreeSet();
    HTMLParser test = new HTMLParser();

    /**
     * Testing the Create Set of Main Page Links method in the HTMLParser Class
     * Expect to return a set with at least 1 element.  Otherwise the website link is bad or down.
     * @throws Exception
     */
    @Test
    public void testCreateSetOfMainPageLinks() throws Exception {

        testSet = test.createSetOfMainPageLinks();
        assertTrue(testSet.size() > 0);


    }

}