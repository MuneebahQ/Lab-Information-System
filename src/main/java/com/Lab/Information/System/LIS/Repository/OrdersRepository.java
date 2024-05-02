package com.Lab.Information.System.LIS.Repository;

import com.Lab.Information.System.LIS.Entity.Orders;
import com.Lab.Information.System.LIS.Entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findByPatId(Patients patId);

}
