package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Create {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setRoll(1);
        s1.setName("Fubuki");
        s1.setAge(22);

        //Build Session Factory
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Open Session
        Session session = sf.openSession();//one session works with one type of query.

        //Save Session
        session.persist(s1);

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