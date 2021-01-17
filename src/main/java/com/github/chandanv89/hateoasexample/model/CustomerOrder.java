package com.github.chandanv89.hateoasexample.model;

import org.springframework.hateoas.RepresentationModel;

import java.util.List;

/**
 * CustomerOrder
 *
 * @author chandanv89
 **/
public class CustomerOrder extends RepresentationModel<CustomerOrder> {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Order> orders;

    public CustomerOrder() {
    }

    public CustomerOrder(Customer customer) {
        id = customer.getCustomerId();
        firstName = customer.getFirstName();
        lastName = customer.getLastName();
        email = customer.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "CustomerOrderDTO{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + orders +
                '}';
    }
}
