package com.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Retrieve {
    public static void main(String[] args) {
        Student s = null;

        //Build Session Factory
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Student.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Open Session
        Session session = sf.openSession();

        //Retrieve data
        s = session.get(Student.class, 1);
        System.out.println(s);

        //Close Session Factory
        sf.close();

        //Close Session
        session.close();
    }
}
