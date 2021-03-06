package com.kopylash.softengi.entity;

import javax.persistence.*;

/**
 * Created by Владислав on 08.09.2015.
 */
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="address_id")
    private Address address;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="employers_id")
    private Employer employer;
    @OneToOne(mappedBy = "user",cascade = {CascadeType.REMOVE,CascadeType.MERGE})
    private Deposit deposit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (deposit != null ? !deposit.equals(user.deposit) : user.deposit != null) return false;
        if (employer != null ? !employer.equals(user.employer) : user.employer != null) return false;
        if (!name.equals(user.name)) return false;
        if (!surname.equals(user.surname)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (employer != null ? employer.hashCode() : 0);
        result = 31 * result + (deposit != null ? deposit.hashCode() : 0);
        return result;
    }
}
