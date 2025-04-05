package com.L2Caching;

import com.HQL.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Create {
    public static void main(String[] args) {

        Bike b1 = new Bike();
        b1.setBrand("Hero");
        b1.setPrice(100000);

        Bike b2 = new Bike();
        b2.setBrand("Enfield");
        b2.setPrice(200000);

        //Build Session Factory
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Bike.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Open Session
        Session session = sf.openSession();

        //Add Data
        session.persist(b1);
        session.persist(b2);

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
