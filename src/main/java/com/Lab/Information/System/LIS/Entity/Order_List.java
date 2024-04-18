package com.Lab.Information.System.LIS.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_list")
public class Order_List {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderlist_id")
    private int orderListId;

    @Column(name = "test_code")
    private int testCode;

    @Column(name = "description")
    private String desCription;

}
