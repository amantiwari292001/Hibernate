package com.hibernate1;

import jakarta.persistence.Embeddable;

@Embeddable //Now we can use the data of this class as columns
public class AdditionalFeatures {
    public boolean sunroof;
    public String fuelType;

    public boolean isSunroof() {
        return sunroof;
    }

    public void setSunroof(boolean sunroof) {
        this.sunroof = sunroof;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Sunroof: " + sunroof + " | Fuel Type: " + fuelType;
    }
}
