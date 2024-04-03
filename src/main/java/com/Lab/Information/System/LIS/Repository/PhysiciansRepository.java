package com.Lab.Information.System.LIS.Repository;

import com.Lab.Information.System.LIS.Entity.Physicians;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysiciansRepository extends JpaRepository<Physicians, Integer> {
    String findByphyId(int id);
}
