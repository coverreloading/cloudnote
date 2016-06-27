package com.cloudnote.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Created by user on 2016/6/21.
 */
public class HibernateUtils {
    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    static {
        configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }


    public static Session openSession() {
        return sessionFactory.openSession();
    }


    public static void main(String[] args) {
        openSession();
    }

}

