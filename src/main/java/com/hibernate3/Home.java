package com.hibernate3;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import static org.hibernate.sql.ast.Clause.FETCH;

@Entity
public class Home {
    @Id
    private int floor;
    private int bhk;
    private boolean balcony;
    @ManyToOne
    private Customer c;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public int getBhk() {
        return bhk;
    }

    public void setBhk(int bhk) {
        this.bhk = bhk;
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Floor: " + floor + " | BHK: " + bhk + "BHK | Balcony: " + balcony;
    }
}
