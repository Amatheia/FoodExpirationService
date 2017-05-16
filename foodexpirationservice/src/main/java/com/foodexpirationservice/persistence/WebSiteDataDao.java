package com.foodexpirationservice.persistence;

import com.foodexpirationservice.entity.WebSiteData;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sue.
 */
public class WebSiteDataDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all items
     *
     * @return All items
     */
    public List<WebSiteData> getAllData() {
        List<WebSiteData> dataList = new ArrayList<WebSiteData>();
        Session session = null;
        try {
            session = openSession();
            dataList = session.createCriteria(WebSiteData.class).list();
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        }
        return dataList;
    }

    public List<WebSiteData> getDataByCategory(String categoryName) {
        List<WebSiteData> dataList = new ArrayList<WebSiteData>();
        Session session = null;
        try {
            session = openSession();
            Criteria criteria = session.createCriteria(WebSiteData.class);
            criteria.add(Restrictions.eq("categoryName", categoryName));
            dataList = criteria.list();
        } catch (HibernateException he) {
            log.error("Exception: " + he);
        } catch (Exception e) {
            log.error("Exception: " + e.getMessage());
        }
        return dataList;
    }

    /**
     * retrieve an item given the id
     *
     * @param itemName the item id
     * @return item
     */
    public List<WebSiteData> getItem(String itemName) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(WebSiteData.class);
        criteria.add(Restrictions.eq("itemName", itemName));
        session.close();
        return criteria.list();

    }

    /** Retrieve items by item name
     *
     * @param newData Item's name which is the search criteria
     * @return Item
     */
    public int addData(WebSiteData newData) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        session.beginTransaction();
        int id = (Integer) session.save(newData);
        session.getTransaction().commit();
        session.close();
        return id;
    }


    private Session openSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }
}