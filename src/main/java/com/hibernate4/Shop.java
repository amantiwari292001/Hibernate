package com.hibernate4;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Shop {
    @Id
    private int shopNo;
    private String sName;
    private int rent;
    @ManyToMany
    private List<Product> productList;

    public int getShopNo() {
        return shopNo;
    }

    public void setShopNo(int shopNo) {
        this.shopNo = shopNo;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopNo=" + shopNo +
                ", sName='" + sName + '\'' +
                ", rent=" + rent +
                ", product=" + productList +
                '}';
    }
}
