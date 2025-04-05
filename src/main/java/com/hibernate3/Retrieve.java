package com.hibernate3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Retrieve {
    public static void main(String[] args) {
        //Build Session Factory
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Home.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Open Session
        Session session = sf.openSession();

        //Retrieve Data
        System.out.println(session.get(Customer.class, 11));

        //Close Session
        session.close();

        //Close Session Factory
        sf.close();
    }
}
