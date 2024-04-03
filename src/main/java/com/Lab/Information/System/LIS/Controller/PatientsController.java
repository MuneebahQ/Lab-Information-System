package com.Lab.Information.System.LIS.Controller;

import com.Lab.Information.System.LIS.Entity.Patients;
import com.Lab.Information.System.LIS.Service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/LIS")
public class PatientsController {

    @Autowired
    PatientsService patientsService;


    @GetMapping("/allPatients")
    public String viewAllPatient(Model model, @Param("keyword") String keyword) {

            List<Patients> listpatients = patientsService.getAllPatients(keyword);
            model.addAttribute("listpatients", listpatients);
            model.addAttribute("keyword", keyword);

        return "PatientsList.html";
    }
}
