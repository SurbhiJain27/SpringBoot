package com.egen.controller;

import com.egen.entity.CustomerOrder;
import com.egen.service.ICustOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/*
1) /ecommerce/order/create: to create order of cuetomer.
2) /ecommerce/order/{orderId}: to fetch customer record.
3) /ecommerce/order/update/{updateOrderId}: to cancel customer's order. For this, soft_delete field
    in customerorder table has been set to false which will indicate that order has been cancelled.*/

@Slf4j
@RestController
@RequestMapping("/ecommerce/order")
public class OrderController {


    @Autowired
    public ICustOrderService custOrderService;

    @PostMapping("/create")
    public Object createOrder(@RequestBody Map<String, Object> custOrderAddr) {
        String output = custOrderService.createOrder(custOrderAddr);
        return output;
    }

    @GetMapping("{orderId}")
    public void getOrder(@PathVariable String orderId) {
        log.info("orderId = " + orderId);
        Optional<CustomerOrder> customerOrder = custOrderService.getOrder(orderId);

        customerOrder.ifPresent(printOrder -> {
                    if (orderId.equals(printOrder.getOrderId()))
                        log.info("order_id found");
                }
        );
    }

    @PutMapping("/update/{updateOrderId}")
    public void updateOrder(@PathVariable String updateOrderId) {
        log.info("orderId = " + updateOrderId);
        int updatedRecord = custOrderService.updateOrder(updateOrderId);
        log.info(" updatedRecord = " + updatedRecord);
    }
}