package com.foodexpirationservice;

import com.foodexpirationservice.controller.ExpirationService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * The FoodExpirationService program implements a rest service that
 * displays food categories, food items, and expiration to the standard output.
 *
 * @authors April Albaugh, Sue Hundt, Heather Hollister
 * @version 1.0
 * @since   2017-04-12
 */
//Defines the base URI for all resource URIs.
@ApplicationPath("/")

//The java class declares root resource and provider classes
public class ExpirationApplication extends Application {

    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(ExpirationService.class );
        return h;
    }
}