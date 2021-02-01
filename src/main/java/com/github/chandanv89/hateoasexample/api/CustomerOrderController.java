package com.github.chandanv89.hateoasexample.api;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandanv89.hateoasexample.model.CustomerOrder;
import com.github.chandanv89.hateoasexample.model.Order;
import com.github.chandanv89.hateoasexample.service.CustomerOrderService;

/**
 * CustomerController
 *
 * @author chandanv89
 **/
@RestController
@RequestMapping("/rest/v1")
public class CustomerOrderController {
	@Autowired
	private CustomerOrderService customerOrderService;

	@GetMapping("/customers")
	public CollectionModel<List<CustomerOrder>> getAllCustomers2() {
		List<CustomerOrder> customers = customerOrderService.getAllCustomers();

		customers.forEach(c -> {
			c.getOrders().forEach(
					o -> o.add(linkTo(methodOn(CustomerOrderController.class).getOrder(o.getOrderId())).withSelfRel()));

			c.add(linkTo(methodOn(CustomerOrderController.class).getCustomer(c.getId())).withSelfRel(),
					linkTo(methodOn(CustomerOrderController.class).getAllCustomerOrders(c.getId())).withRel("orders"));
		});

		return CollectionModel.of(Collections.singleton(customers),
				linkTo(methodOn(CustomerOrderController.class).getAllCustomers2()).withSelfRel());
	}

	@GetMapping("/customers/{customerId}")
	public EntityModel<CustomerOrder> getCustomer(@PathVariable("customerId") String customerId) {
		CustomerOrder customer = customerOrderService.getCustomerById(customerId);
		customer.getOrders().forEach(
				o -> o.add(linkTo(methodOn(CustomerOrderController.class).getOrder(o.getOrderId())).withSelfRel()));
		return EntityModel.of(customer,
				linkTo(methodOn(CustomerOrderController.class).getCustomer(customerId)).withSelfRel(),
				linkTo(methodOn(CustomerOrderController.class).getAllCustomerOrders(customerId)).withRel("orders"),
				linkTo(methodOn(CustomerOrderController.class).getAllCustomers2()).withRel("allCustomers"));
	}

	@GetMapping("/customers/{customerId}/orders")
	public CollectionModel<Order> getAllCustomerOrders(@PathVariable("customerId") String customerId) {
		List<Order> orders = customerOrderService.getOrdersByCustomerId(customerId);
		orders.forEach(
				o -> o.add(linkTo(methodOn(CustomerOrderController.class).getOrder(o.getOrderId())).withSelfRel()));

		return CollectionModel.of(orders,
				linkTo(methodOn(CustomerOrderController.class).getAllCustomerOrders(customerId)).withSelfRel());
	}

	@GetMapping("/orders")
	public CollectionModel<Order> getOrders() {
		List<Order> orderList = customerOrderService.getAllOrders();
		orderList.forEach(o -> {
			o.add(linkTo(methodOn(CustomerOrderController.class).getOrder(o.getOrderId())).withSelfRel());
			o.add(linkTo(methodOn(CustomerOrderController.class).getCustomer(o.getCustomerId()))
					.withRel("customerInfo"));
		});
		return CollectionModel.of(orderList, linkTo(methodOn(CustomerOrderController.class).getOrders()).withSelfRel());
	}

	@GetMapping("/orders/{orderId}")
	public EntityModel<Order> getOrder(@PathVariable("orderId") String orderId) {
		Order order = customerOrderService.getOrderByOrderId(orderId);
		return EntityModel.of(order, linkTo(methodOn(CustomerOrderController.class).getOrder(orderId)).withSelfRel(),
				linkTo(methodOn(CustomerOrderController.class).getCustomer(order.getCustomerId()))
						.withRel("customerInfo"),
				linkTo(methodOn(CustomerOrderController.class).getOrders()).withRel("allOrders"));
	}
}
