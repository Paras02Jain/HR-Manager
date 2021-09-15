package com.nagarro.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbSession {

    private static Session dbSession;

    private DbSession() {

    }

    // Creating Session
    public static Session getSession() {
        if (dbSession == null) {
            SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml").buildSessionFactory();
            dbSession = sessionFactory.openSession();
        }
        return dbSession;
    }

    // Closing Session
    public static void closeSession() {
        dbSession.close();

    }
}
