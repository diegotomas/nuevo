package com.prueba.spring.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
        	Configuration conf = new Configuration();
            sessionFactory = conf.configure().buildSessionFactory();
        } catch (Throwable ex) {
           ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
