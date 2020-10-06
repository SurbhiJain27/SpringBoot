package com.egen.repository;

import com.egen.entity.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {
    //#TODO - Its for future's validation/implementation purpose
}
