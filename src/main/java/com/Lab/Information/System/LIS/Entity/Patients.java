package com.Lab.Information.System.LIS.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class Patients extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pat_id")
    private int patId;

    @Column(name = "LName")
    private String lName;

    @Column(name = "FName")
    private String fName;

    @Column(name = "DOB")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate DOB;

    @Column(name = "SSN")
    private String SSN;

    @Column(name = "Address")
    private String address;

    @Column(name = "city")
    private String City;

    @Column(name = "state")
    private String State;

    @Column(name = "zipcode")
    private int zipcode;

    @Column(name = "orderdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderdate;

//    @Column(name = "physician_id")
    @OneToOne(fetch = FetchType.EAGER, targetEntity = Physicians.class)
    @JoinColumn(name = "physician_id", referencedColumnName = "phy_id",nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Physicians phyId;

}
