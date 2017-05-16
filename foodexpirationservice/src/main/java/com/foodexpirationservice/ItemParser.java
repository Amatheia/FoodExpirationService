package com.foodexpirationservice;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 ** * The FoodExpirationService program implements a rest service that
 *    displays food categories, food items, and expiration to the standard output.
 *
 * @authors April Albaugh, Sue Hundt, Heather Hollister
 * @version 1.0
 * @since   2017-04-12
 * Class that returns the HTML tables elements from each link returned in the HTMLParser Class.
 */
public class ItemParser {


    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Takes each url and uses Jsoup to return table data
     * @param parserObject
     * @return
     */
    public ArrayList<String> createMetaDataArrays(Object parserObject) {

        Document doc;
        String itemString = "";
        String itemSegment = "";
        String url = (String) parserObject;

        ArrayList<String> itemSegments = new ArrayList<String>();


        try {

            doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.0) AppleWebKit/536.5 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/536.5")
                    .timeout(100000)
                    .ignoreHttpErrors(true)
                    .get();

            String title = doc.title();

            itemSegments.add(title);

            Element table = doc.select("table").get(0); //select the first table.
            Elements rows = table.select("tr");

            Elements headings = rows.select("th");

            for (int i = 1; i < headings.size(); i++) { //first row is the col names so skip it.
                Element data = headings.get(i);
                Elements cols = data.select("th");
                itemSegment = cols.text();
                // breaks multi-level of escaping, preventing &amp;lt;script&amp;gt; to be rendered as <script>
                String replace2 = itemSegment.replace("&amp;", "");
                // decode any encoded html, preventing &lt;script&gt; to be rendered as <script>
                String html2 = StringEscapeUtils.unescapeHtml4(replace2);
                // remove all html tags, but maintain line breaks
                String clean2 = Jsoup.clean(html2, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
                // decode html again to convert character entities back into text
                String newString2 = StringEscapeUtils.unescapeHtml4(clean2);

                itemSegments.add(newString2);

            }

            Elements dataElements = rows.select("td");

            for (int i = 1; i < dataElements.size(); i++) { //first row is the col names so skip it.
                Element data = dataElements.get(i);
                Elements cols = data.select("td");
                itemSegment = cols.text();
                // breaks multi-level of escaping, preventing &amp;lt;script&amp;gt; to be rendered as <script>
                String replace2 = itemSegment.replace("&amp;", "");
                // decode any encoded html, preventing &lt;script&gt; to be rendered as <script>
                String html2 = StringEscapeUtils.unescapeHtml4(replace2);
                // remove all html tags, but maintain line breaks
                String clean2 = Jsoup.clean(html2, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
                // decode html again to convert character entities back into text
                String newString2 = StringEscapeUtils.unescapeHtml4(clean2);

                itemSegments.add(newString2);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return itemSegments;

    }

}