package com.foodexpirationservice.error;

/**
 * The FoodExpirationService program implements a rest service that
 * displays food categories, food items, and expiration to the standard output.
 *
 * @authors April Albaugh, Sue Hundt, Heather Hollister
 * @version 1.0
 * @since   2017-04-12
 */
public class ServiceError {

    private String message;

    /**
     * The ResponseError method creates a message for the user.
     */
    public String getResponseErrorMessage() {
        message = "HTTP status code: 500. You have reached this page in error. Please ensure that your path and all of the " +
                "path variables are correct. Paths and their uses can be found in the documentation:\n\n" +

                "https://github.com/Amatheia/FoodExpirationService/blob/master/USERDOC.md" +

                "If all else fails, the server may be down. Our apologies.";

        return message;
    }

}
