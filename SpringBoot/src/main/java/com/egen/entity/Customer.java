package com.egen.entity;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id")
    int customerId;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email")
    String email;

    // cascade deletes the Child class entries when parent is getting deleted
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    Address customerAddress;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "paymentCustomer")
    Payment payment;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orderCustomer")
    CustomerOrder customerOrder ;

    @Column(name = "created_date")
    LocalDateTime createdDate;

    @Column(name = "created_by")
    String createdBy;

    @UpdateTimestamp
    @Column(name = "modified_date")
    LocalDateTime modifiedDate;

    @Column(name = "modified_by")
    String modifiedBy;

    public Customer() {
        this.createdDate = LocalDateTime.now();
    }

}
