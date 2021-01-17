package com.github.chandanv89.hateoasexample.persistence;

import com.github.chandanv89.hateoasexample.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * OrderRepository
 *
 * @author chandanv89
 **/
@Repository
public interface OrderRepository extends CrudRepository<Order, String> {
    Iterable<Order> findAllByCustomerId(String customerId);
}
