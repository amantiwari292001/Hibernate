package com.L2Caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Retrieve {
    public static void main(String[] args) {
        //Build Session Factory
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Bike.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Open Session
        Session session1 = sf.openSession();
        Session session2 = sf.openSession();

        //File Retrieve Query
        System.out.println(session1.get(Bike.class,"Hero"));
        System.out.println(session2.get(Bike.class,"Hero"));


        //Close Session
        session1.close();
        session2.close();

        //Close Session Factory
        sf.close();
    }
}
