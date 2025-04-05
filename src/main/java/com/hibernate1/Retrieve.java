package com.hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Retrieve {
    public static void main(String[] args) {
        //Build Session Factory
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Car.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Open Session
        Session session = sf.openSession();

        //Retrieve Data
        System.out.println(session.get(Car.class, "Tata"));

        //Close Session
        session.close();

        //Close Session Factory
        sf.close();
    }
}
