package com.HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Create {
    public static void main(String[] args) {
        Phone p1 = new Phone();
        Phone p2 = new Phone();

        p1.setBrand("Samsung");
        p1.setModel("S20");
        p1.setBattery(4200);
        p1.setRam(8);
        p1.setRom(128);
        p1.setPrice(41000);

        p2.setBrand("Google");
        p2.setModel("Pixel 8");
        p2.setBattery(4100);
        p2.setRam(12);
        p2.setRom(256);
        p2.setPrice(50000);

        //Build Session Factory
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Phone.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Open Session
        Session session = sf.openSession();

        //Add Data
        session.persist(p1);
        session.persist(p2);

        //Begin Transaction
        Transaction t = session.beginTransaction();

        //Commit Transaction
        t.commit();

        //Close Session
        session.close();

        //Close Session Factory
        sf.close();
    }
}
