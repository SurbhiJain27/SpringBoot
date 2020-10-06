package com.egen.repository;

import com.egen.entity.CustomerOrder;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Integer> {

    @Query(value ="SELECT c.* FROM customerorder c where c.order_id = ?1", nativeQuery = true)
    Optional<CustomerOrder> findByOrderId(String order_id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE customerorder SET soft_delete = false WHERE order_id = ?1", nativeQuery = true)
    int updateByOrderId(String order_id);
}