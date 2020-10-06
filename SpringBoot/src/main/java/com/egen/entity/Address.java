package com.egen.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @SequenceGenerator(name="jpaPkSeq", sequenceName="JPA_PK_SEQ", allocationSize=1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaPkSeq")
    @Column(name = "address_id")
    long addressId;

    @Column(name = "address_line1")
    String addressLineOne;

    @Column(name = "address_line2")
    String addressLineTwo;

    String city;

    String state;

    String postcode;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customerAddress")
    Customer customer;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "paymentAddress")
    Payment payment;

}