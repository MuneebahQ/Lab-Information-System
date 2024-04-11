package com.Lab.Information.System.LIS.Service;

import com.Lab.Information.System.LIS.Entity.Physicians;
import com.Lab.Information.System.LIS.Repository.PhysiciansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhysiciansService {

    @Autowired
    PhysiciansRepository physiciansRepository;

    public List<Physicians> getAllPhysicians() {
        return physiciansRepository.findAll();
    }

    public Physicians addOrUpdatePhysician(Physicians physician) {
        return physiciansRepository.save(physician);
    }

    public Physicians getPhysicianById(int physicianId) {
        return physiciansRepository.findById(physicianId).orElse(null);
    }
}
