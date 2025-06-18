package com.SpringApplication.entity;

import jakarta.persistence.Embeddable;


@Embeddable
public class Address {
    private String area;
    private String city;
    private String state;
    private String country;
    private String pincode;

    // No-argument constructor
    public Address() {
    }

    // All-arguments constructor
    public Address(String area, String city, String state, String country, String pincode) {
        this.area = area;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    // Getters
    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPincode() {
        return pincode;
    }

    // Setters
    public void setArea(String area) {
        this.area = area;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}