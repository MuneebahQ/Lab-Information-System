package com.Lab.Information.System.LIS.Repository;

import com.Lab.Information.System.LIS.Entity.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientsRepository extends JpaRepository<Patients, Integer> {
    List<Patients> findBylNameStartingWith(String keyword);


    Patients findBypatId(int id);
}

