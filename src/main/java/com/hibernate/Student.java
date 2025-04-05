package com.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity //Whose data would become row and column
//@Table(name = "Table_Name"), To change table name
public class Student {

    @Id //Primary key
    private int roll;
//    @Column(name = "sName"), To change column name
    private String name;
    private int age;

//    @Transient, It won't let hibernate to create data column of marks.
//    private int marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String toString() {
        return "Roll: " + roll + " | Name: " + name +  " | Age: " + age;
    }
}
