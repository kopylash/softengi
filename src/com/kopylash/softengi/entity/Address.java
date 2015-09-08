package com.kopylash.softengi.entity;

import javax.persistence.*;

/**
 * Created by Владислав on 08.09.2015.
 */
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String street;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (id != address.id) return false;
        if (!city.equals(address.city)) return false;
        if (!street.equals(address.street)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return city +
                ", " + street;
    }
}
