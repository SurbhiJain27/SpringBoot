package com.egen.service;

import com.egen.entity.CustomerOrder;

import java.util.Map;
import java.util.Optional;

public interface ICustOrderService {

    public String createOrder(Map<String, Object> custOrderAddr);

    public Optional<CustomerOrder> getOrder(String orderId);

    public int updateOrder(String updateOrderId);
}
