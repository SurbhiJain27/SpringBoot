package com.egen.entity;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "customerorder")
public class CustomerOrder {

    @Id
    @Column(name = "order_id")
    String orderId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    Customer orderCustomer;

    @Column(name = "order_date")
    LocalDateTime orderDate;

    @Column(name = "order_subtotal")
    double orderSubTotal;

    @Column(name = "order_tax")
    double orderTax = 0.10;

    @Column(name = "order_total")
    double orderTotal;

    @Column(name = "created_date")
    LocalDateTime createdDate;

    @Column(name = "created_by")
    String createdBy = "System";

    @UpdateTimestamp
    @Column(name = "modified_date")
    LocalDateTime modifiedDate;

    @Column(name = "modified_by")
    String modifiedBy = "Surbhi";

    @Column(name = "soft_delete")
    boolean softDelete = true;

    @Column(name = "shipping_charge")
    double shipCharge = 2.0;

    @Column(name = "payment_date")
    LocalDateTime paymentDate;

    @SequenceGenerator(name="custorderpaymentSeq", sequenceName="CUSTORDERPAYMENT_SEQ", allocationSize=1, initialValue = 990)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custorderpaymentSeq")
    @Column(name = "payment_conf_no")
    long paymentConfNo;

    public CustomerOrder()
    {
        this.orderId = UUID.randomUUID().toString();
        this.createdDate = LocalDateTime.now();
        this.paymentDate = LocalDateTime.now();
        this.orderDate = LocalDateTime.now();
    }
}
