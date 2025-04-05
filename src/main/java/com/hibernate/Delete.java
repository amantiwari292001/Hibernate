package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {
    public static void main(String[] args) {
        Student s = null;

        //Build Session Factory
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Open Session
        Session session = sf.openSession();

        //Retrieving Session
        s = session.get(Student.class, 6);

        //Deleting data
        session.remove(s);

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
