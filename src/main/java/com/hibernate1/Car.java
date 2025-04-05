package com.hibernate1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car {
    @Id
    private String brand;
    private int year;
    private float mileage;
    private AdditionalFeatures af;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getMileage() {
        return mileage ;
    }

    public void setMileage(float mileage) {
        this.mileage  = mileage;
    }

    public AdditionalFeatures getAf() {
        return af;
    }

    public void setAf(AdditionalFeatures af) {
        this.af = af;
    }

    public String toString() {
        return "Brand: " + brand + " | Year: " + year + " | Mileage: " + mileage + " | " + af;
    }
}
