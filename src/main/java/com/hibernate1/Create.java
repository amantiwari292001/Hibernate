package com.hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Create {
    public static void main(String[] args) {
        AdditionalFeatures af = new AdditionalFeatures();
        af.setSunroof(true);
        af.setFuelType("Petrol");

        Car c = new Car();
        c.setBrand("Tata");
        c.setYear(2020);
        c.setMileage(35.5f);
        c.setAf(af);

        //Build Session Factory
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Car.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Open Session
        Session session = sf.openSession();

        //Save Data
        session.persist(c);

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
