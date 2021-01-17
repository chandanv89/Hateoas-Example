package com.github.chandanv89.hateoasexample.model;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.Date;

/**
 * Order
 *
 * @author chandanv89
 **/
@Entity
@Table(name = "ORDER_INFO")
public class Order extends RepresentationModel<Order> {
    @Id
    @Column(name = "ORDER_ID")
    @GenericGenerator(name = "guid", strategy = "com.github.chandanv89.hateoasexample.generator.GuidGenerator")
    @GeneratedValue(generator = "guid")
    private String orderId;

    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "ORDER_VALUE")
    private String orderValue;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    public Order() {

    }

    public Order(String orderId, String customerId, String orderValue, Date orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderValue = orderValue;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(String orderValue) {
        this.orderValue = orderValue;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", value='" + orderValue + '\'' +
                ", date=" + orderDate +
                '}';
    }
}
