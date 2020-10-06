package com.egen.repository;

import com.egen.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    //#TODO - Its for future's validation/implementation purpose
}
