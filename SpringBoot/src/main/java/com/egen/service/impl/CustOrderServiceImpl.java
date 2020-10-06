package com.egen.service.impl;

import com.egen.entity.*;
import com.egen.repository.*;
import com.egen.service.ICustOrderService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustOrderServiceImpl implements ICustOrderService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CustomerOrderRepository customerOrderRepository;

    CustomerOrder customerOrderObject = new CustomerOrder();

    int countItem = 0; //to count stocked items

    double orderSubTotal = 0.0;
    double orderTotal = 0.0;

    public String createOrder(Map<String, Object> custOrderAddr) {
        Gson gson = new GsonBuilder().create();
        Object objectCustomer = custOrderAddr.get("customer");
        Object objectAddress = custOrderAddr.get("address");
        Object objectPayment = custOrderAddr.get("payment");
        Object objectItems = custOrderAddr.get("items");

        Customer customer = gson.fromJson(objectCustomer.toString(), Customer.class);
        Address address = gson.fromJson(objectAddress.toString(), Address.class);
        Payment payment = gson.fromJson(objectPayment.toString(), Payment.class);
        ItemQuantity[] arraysItems = gson.fromJson(objectItems.toString(), ItemQuantity[].class);

        Arrays.stream(arraysItems).forEach(System.out::println); //Print the Object of Items having itemId and itemQuantity

        List<Integer> ids = new ArrayList<>();

        Arrays.stream(arraysItems).forEach(x -> {
                    ids.add(x.getItemId());
                }
        );

        for (int i : ids) {
            if (itemRepository.existsById(i)) {
                Optional<Item> itemIds = itemRepository.findById(i);
                Item items = itemIds.get();
                System.out.println(items.getItemUnitPrice());
                orderSubTotal = orderSubTotal + (items.getItemUnitPrice() * items.getItemQuantity());
                countItem++;
            }
        }

        if(countItem == 0)
        {
            return "record can't be created because of out of stock of items";
        }

        //updating order column order_sub_total and order_total
        orderTotal = orderSubTotal + customerOrderObject.getOrderTax() + customerOrderObject.getShipCharge();
        customerOrderObject.setOrderSubTotal(orderSubTotal);
        customerOrderObject.setOrderTotal(orderTotal);

        customer.setCustomerAddress(address); //link between customer and address table
        address.setCustomer(customer);

        payment.setPaymentAddress(address); //link between payment and customer table
        address.setPayment(payment);

        payment.setPaymentCustomer(customer); //link between payment and customer table
        customer.setPayment(payment);

        customerOrderObject.setOrderCustomer(customer); //link between customer and customerorder table
        customer.setCustomerOrder(customerOrderObject);

        addressRepository.save(address);

        return "record in order table has created";
    }

    //fetch customer's data
    public Optional<CustomerOrder> getOrder(String orderId) {
        Optional<CustomerOrder> customerOrder = customerOrderRepository.findByOrderId(orderId);
        return customerOrder;

    }

    //cancel customer's order
    public int updateOrder(String updateOrderId)
    {
        int updatedRecords = customerOrderRepository.updateByOrderId(updateOrderId);

        return updatedRecords;

    }


}

