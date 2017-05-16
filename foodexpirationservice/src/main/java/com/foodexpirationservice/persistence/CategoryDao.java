package com.foodexpirationservice.persistence;

import com.foodexpirationservice.entity.Category;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * The FoodExpirationService program implements a rest service that
 * displays food categories, food items, and expiration to the standard output.
 *
 * @authors April Albaugh, Sue Hundt, Heather Hollister
 * @version 1.0
 * @since   2017-04-12
 */
public class CategoryDao {

    private final Logger log = Logger.getLogger(this.getClass());
    List<Category> categoriesList;

    /** Return a list of all categories
     *
     * @return All categories
     */
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<Category>();
        Session session = null;
        try {
            session = openSession();
            categories = session.createCriteria(Category.class).list();
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        }
        return categories;
    }

    /**
     * retrieve a category given their id
     *
     * @param id the category id
     * @return category The category
     */
    public Category getCategory(int id) {
        Category category = null;
        Session session = null;
        try {
            session = openSession();
            category = (Category) session.get(Category.class, id);
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return category;
    }

    /**
     * retrieve a category given the name
     *
     * @param categoryName the category name
     * @return category The category
     */
    public Category getCategoryName(String categoryName) {
        Category category = null;
        Session session = null;
        try {
            session = openSession();
            Criteria criteria = session.createCriteria(Category.class);
            criteria.add(Restrictions.eq("categoryName", categoryName));
            Object result = criteria.uniqueResult();
            if (result != null) {
                category = (Category) result;
            }
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e );
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return category;
    }

    private Session openSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

}
