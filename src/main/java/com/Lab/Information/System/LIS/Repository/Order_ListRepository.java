package com.Lab.Information.System.LIS.Repository;

import com.Lab.Information.System.LIS.Entity.Order_List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_ListRepository extends JpaRepository<Order_List, Integer> {
}
