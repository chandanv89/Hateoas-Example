package com.github.chandanv89.hateoasexample.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Customer
 *
 * @author chandanv89
 **/
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @Id
    @Column(name = "CUSTOMER_ID")
    @GenericGenerator(name = "guid", strategy = "com.github.chandanv89.hateoasexample.generator.GuidGenerator")
    @GeneratedValue(generator = "guid")
    private String customerId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    public Customer() {
    }

    public Customer(String customerId, String firstName, String lastName, String email) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
