package com.example.learn.Entites;

public class Address {

    String homeAddress;
    String city;
    String state;
    String country;

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address(String homeAddress, String city, String state, String country) {
        this.homeAddress = homeAddress;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public Address() {

    }
}
