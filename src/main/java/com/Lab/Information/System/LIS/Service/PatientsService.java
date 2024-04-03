package com.Lab.Information.System.LIS.Service;

import com.Lab.Information.System.LIS.Entity.Patients;
import com.Lab.Information.System.LIS.Repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PatientsService {

    @Autowired
    PatientsRepository patientsRepository;

    public List<Patients> getAllPatients(String Keyword) {
        if (Keyword != null) {
            List<Patients> pat = patientsRepository.findBylName(Keyword);
            Collections.reverse(pat);
            return pat;
        }

        List<Patients> patients = patientsRepository.findAll(Sort.by("patId").descending());
        Collections.reverse(patients);
        return patients;
    }

}
