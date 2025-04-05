package com.hibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Retrieve {
    public static void main(String[] args) {
        //Build Session Factory
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Laptop.class) //To retrieve Laptop we don't need to add other classes.
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Open Session
        Session session = sf.openSession();

        //Retrieve Data
        System.out.println(session.get(Employee.class,101));

        //Close Session
        session.close();

        //Close Session Factory
        sf.close();
    }
}
