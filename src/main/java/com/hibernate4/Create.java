package com.hibernate4;

import com.hibernate3.Customer;
import com.hibernate3.Home;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Create {
    public static void main(String[] args) {

        Product p1 = new Product();
        p1.setpId(1);
        p1.setpName("Ice Cream");

        Product p2 = new Product();
        p2.setpId(2);
        p2.setpName("Mango");

        Product p3 = new Product();
        p3.setpId(3);
        p3.setpName("TV");

        Shop s1 = new Shop();
        s1.setShopNo(1001);
        s1.setsName("Raju Kirana");
        s1.setRent(12000);
        s1.setProductList(List.of(p1,p2));

        Shop s2 = new Shop();
        s2.setShopNo(1002);
        s2.setsName("All in one store");
        s2.setRent(50000);
        s2.setProductList(List.of(p2,p3));

        Shop s3 = new Shop();
        s3.setShopNo(1003);
        s3.setsName("Super market");
        s3.setRent(4000);
        s3.setProductList(List.of(p1,p3));

        p1.setShopList(List.of(s1,s3));
        p2.setShopList(List.of(s1,s2));
        p3.setShopList(List.of(s2,s3));


        //Build Session Factory
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Shop.class)
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Open Session
        Session session = sf.openSession();

        //Add Data
        session.persist(p1);//Child
        session.persist(p2);//Child
        session.persist(p3);//Parent
        session.persist(s1);
        session.persist(s2);
        session.persist(s3);

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
