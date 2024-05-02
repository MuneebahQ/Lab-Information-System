package com.Lab.Information.System.LIS.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private int orderId;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST, targetEntity = Order_List.class)
    @JoinColumn(name = "orderlist_id", referencedColumnName = "orderlist_id",nullable = false)
    private Order_List orderListId;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST, targetEntity = Patients.class)
    @JoinColumn(name = "pat_id", referencedColumnName = "pat_id",nullable = false)
    private Patients patId;

    @Column(name = "date_ordered")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    public Orders(Order_List orderListId, Patients patId, LocalDate orderDate) {
        this.orderListId = orderListId;
        this.patId = patId;
        this.orderDate = orderDate;


    }
}
