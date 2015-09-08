package com.kopylash.softengi.entity;

import javax.persistence.*;

/**
 * Created by Владислав on 08.09.2015.
 */
@Entity
@Table(name="employers")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String company;
    @Column(name = "activity_field")
    private String activityField;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "address_id")
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getActivityField() {
        return activityField;
    }

    public void setActivityField(String activityField) {
        this.activityField = activityField;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;

        Employer employer = (Employer) o;

        if (id != employer.id) return false;
        if (!activityField.equals(employer.activityField)) return false;
        if (!address.equals(employer.address)) return false;
        if (!company.equals(employer.company)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + company.hashCode();
        result = 31 * result + activityField.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return company +
                ", " + activityField +
                ", \n" + address.toString();
    }
}
