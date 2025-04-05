package com.hibernate3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Create {
    public static void main(String[] args) {
        Home h1 = new Home();
        h1.setFloor(1);
        h1.setBhk(3);
        h1.setBalcony(true);

        Home h2 = new Home();
        h2.setFloor(2);
        h2.setBhk(1);
        h2.setBalcony(false);

        Customer c = new Customer();
        c.setcId(11);
        c.setcName("Customer 1");
        c.setAge(35);
        c.setHomeList(List.of(h1,h2));

        h1.setC(c);
        h2.setC(c);

        //Build Session Factory
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Home.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Open Session
        Session session = sf.openSession();

        //Add Data
        session.persist(h1);//Child
        session.persist(h2);//Child
        session.persist(c);//Parent

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
