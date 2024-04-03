package com.Lab.Information.System.LIS.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "physicians")
public class Physicians {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phy_id")
    private int phyId;

    @Column(name = "name")
    private String name;

    @Column(name = "office_address")
    private String officeaddress;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipcode")
    private int zipCode;

}
