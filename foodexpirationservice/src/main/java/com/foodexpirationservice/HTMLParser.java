package com.foodexpirationservice;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 ** * The FoodExpirationService program implements a rest service that
 *    displays food categories, food items, and expiration to the standard output.
 *
 * @authors April Albaugh, Sue Hundt, Heather Hollister
 * @version 1.0
 * @since   2017-04-12
 * Entity for data brought in from the EatByDate.com website and stored in the webSiteData1 table of
 * the foodexpiration database.
 */
public class HTMLParser {

    private final Logger log = Logger.getLogger(this.getClass());
    /**
     * Local variables used to store data and build a TreeSet
     */
    String linkText = "";
    Set hrefSet = new TreeSet();
    Document doc;

    /**
     * Method that uses Jsoup to retrieve the HTML from it's main webpage
     * Data is stored in a TreeSet to avoid duplicates
     * @return
     */
    public TreeSet<String> createSetOfMainPageLinks() {

        try {

            doc = Jsoup.connect("http://www.eatbydate.com")
                    .userAgent("Mozilla/5.0 (Windows NT 6.0) AppleWebKit/536.5 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/536.5")
                    .timeout(100000)
                    .ignoreHttpErrors(true)
                    .get();

            Elements links = doc.select("a[href]");
            for (Element link : links) {
                linkText = (String) link.attr("href");
                hrefSet.add(linkText);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("Treeset of urls has been created.  Size is: " + hrefSet.size());
        return (TreeSet<String>) hrefSet;
    }


}
