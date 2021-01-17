package com.github.chandanv89.hateoasexample.service;

import com.github.chandanv89.hateoasexample.model.Customer;
import com.github.chandanv89.hateoasexample.model.CustomerOrder;
import com.github.chandanv89.hateoasexample.model.Order;
import com.github.chandanv89.hateoasexample.persistence.CustomerRepository;
import com.github.chandanv89.hateoasexample.persistence.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * CustomerOrderService
 *
 * @author chandanv89
 **/
@Service
public class CustomerOrderService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<CustomerOrder> getAllCustomers() {
        List<CustomerOrder> customerOrders = new ArrayList<>();

        Iterable<Customer> customers = customerRepository.findAll();

        for (Customer cust : customers) {
            List<Order> ordersForCustomer = new ArrayList<>();

            Iterable<Order> orders = orderRepository.findAllByCustomerId(cust.getCustomerId());
            for (Order o : orders) {
                ordersForCustomer.add(o);
            }

            CustomerOrder customerOrder = new CustomerOrder(cust);
            customerOrder.setOrders(ordersForCustomer);
            customerOrders.add(customerOrder);
        }

        return customerOrders;
    }

    public CustomerOrder getCustomerById(String customerId) {
        Optional<Customer> optional = customerRepository.findById(customerId);
        CustomerOrder customerOrder = null;

        if (optional.isPresent()) {
            customerOrder = new CustomerOrder(optional.get());
            Iterable<Order> orders = orderRepository.findAllByCustomerId(customerOrder.getId());

            List<Order> customerOrders = new ArrayList<>();
            orders.forEach(customerOrders::add);

            customerOrder.setOrders(customerOrders);
        }

        return customerOrder;
    }

    public List<Order> getOrdersByCustomerId(String customerId) {
        Iterable<Order> orders = orderRepository.findAllByCustomerId(customerId);

        List<Order> orderList = new ArrayList<>();
        orders.forEach(orderList::add);

        return orderList;
    }

    public List<Order> getAllOrders() {
        List<Order> orderList = new ArrayList<>();

        Iterable<Order> orders = orderRepository.findAll();
        orders.forEach(orderList::add);

        return orderList;
    }

    public Order getOrderByOrderId(String orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
}
