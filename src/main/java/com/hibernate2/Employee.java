package com.hibernate2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
    @Id
    private int eId;
    private String eName;
    private String tech;
    @OneToOne //Need this annotation to relate laptop with employee, Adding a foreign key (primary key of laptop)
    private Laptop laptop;

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public String toString(){
        return "Employee Id: " + eId + " | Employee Name: " + eName + " | Employee Tech: " + tech + laptop;
    }
}
