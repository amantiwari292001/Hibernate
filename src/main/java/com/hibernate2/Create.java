package com.hibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Create {
    public static void main(String[] args) {
        Laptop l = new Laptop();
        l.setlId(1);
        l.setBrand("Lenovo");
        l.setModel("Legion");

        Employee e = new Employee();
        e.seteId(101);
        e.seteName("Dhoni");
        e.setTech("Java");
        e.setLaptop(l);

        //Build Session Factory
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Laptop.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Open Session
        Session session = sf.openSession();

        //Save Data
        session.persist(l); //First add child so that parent column can't be null
        session.persist(e);

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
