package com.foodexpirationservice.persistence;

import com.foodexpirationservice.entity.Item;
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
public class ItemDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all items
     *
     * @return All items
     */
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<Item>();
        Session session = null;
        try {
            session = openSession();
            items = session.createCriteria(Item.class).list();
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        }
        return items;
    }

    public List<Item> getItemsByCategory(int categoryId) {
        List<Item> items = new ArrayList<Item>();
        Session session = null;
        try {
            session = openSession();
            Criteria criteria = session.createCriteria(Item.class);
            criteria.add(Restrictions.eq("categoryId", categoryId));
            items = criteria.list();
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        }
        return items;
    }

    /**
     * retrieve an item given the name
     *
     * @param itemName the item name
     * @return item
     */
    public Item getItemName(String itemName) {
        Item item = null;
        Session session = null;
        try {
            session = openSession();
            Criteria criteria = session.createCriteria(Item.class);
            criteria.add(Restrictions.eq("itemName", itemName));
            Object result = criteria.uniqueResult();
            if (result != null) {
                item = (Item) result;
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
        return item;
    }

    /**
     * retrieve an item given the id
     *
     * @param id the item id
     * @return item
     */
    public Item getItem(int id) {
        Item item = null;
        Session session = null;
        try {
            session = openSession();
            item = (Item) session.get(Item.class, id);
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return item;
    }

    /** Retrieve items by item name
     *
     * @param itemName Item's name which is the search criteria
     * @return Item
     */
    public List<Item> getItemsByName(String itemName) {
        List<Item> items = new ArrayList<Item>();
        Session session = null;
        try {
            session = openSession();
            Criteria criteria = session.createCriteria(Item.class);
            criteria.add(Restrictions.eq("itemName", itemName));
            items = criteria.list();
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e );
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return items;
    }

    private Session openSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}
