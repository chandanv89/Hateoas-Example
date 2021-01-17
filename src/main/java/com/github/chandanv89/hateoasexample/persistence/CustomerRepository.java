package com.github.chandanv89.hateoasexample.persistence;

import com.github.chandanv89.hateoasexample.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomerRepository
 *
 * @author chandanv89
 **/
@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
}
