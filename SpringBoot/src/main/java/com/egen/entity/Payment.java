package com.egen.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @SequenceGenerator(name="paymentPkSeq", sequenceName="CUSTPAYMENT_PK_SEQ", allocationSize=1, initialValue = 1001)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paymentPkSeq")
    @Column(name = "payment_id")
    long paymentId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    Customer paymentCustomer;

    @Column(name = "card_no")
    String cardNo;

    @Column(name = "payment_type")
    String paymentType;

    String merchant;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    Address paymentAddress;


}
