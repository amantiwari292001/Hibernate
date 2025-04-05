package com.L2Caching;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
public class Bike {
    @Id
    private String Brand;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "Brand='" + Brand + '\'' +
                ", price=" + price +
                '}';
    }
}
