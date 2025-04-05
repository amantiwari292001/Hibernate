package com.HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Retrieve {
    public static void main(String[] args) {
        //Build Session Factory
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Phone.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Open Session
        Session session = sf.openSession();

        //Retrieve with HQL
        //When getting columns or specific value, Using Object class helps in casting.
        Query<Object[]> query1 = session.createQuery("SELECT brand, model, rom, ram, battery, price FROM Phone", Object[].class);
        List<Object[]> phoneData1 = query1.getResultList();
        for(Object[] o: phoneData1){
            System.out.printf("Brand: %s, Model: %s, Memory: %sGB, RAM: %sGB, Battery: %sMAH, Price: Rs.%s",o[0],o[1],o[2],o[3],o[4],o[5]);
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------------------------------------");
        //When getting a whole row in one entity. With parameter and condition
        Query<Object> query2 = session.createQuery("FROM Phone WHERE brand LIKE ?1",Object.class);
        List <Object>phoneData2 = query2.setParameter(1,"Samsung").getResultList();
        for(Object list: phoneData2){
            System.out.println(list);
        }

        //Close Session
        session.close();

        //Close Session Factory
        sf.close();
    }
}
