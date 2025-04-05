package com.hibernate3;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Customer {
    @Id
    private int cId;
    private String cName;
    private int age;
    @OneToMany(mappedBy = "c")
    private List<Home> homeList; //For oneToMany relation we need List

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Home> getHomeList() {
        return homeList;
    }

    public void setHomeList(List<Home> homeList) {
        this.homeList = homeList;
    }

    @Override
    public String toString() {
        return "Customer Id: " + cId + " | Customer Name: " + cName + " | Customer Age: " + age + " | " + homeList;
    }
}
