package com.Lab.Information.System.LIS.Controller;

import com.Lab.Information.System.LIS.Entity.Patients;
import com.Lab.Information.System.LIS.Entity.Physicians;
import com.Lab.Information.System.LIS.Service.PatientsService;
import com.Lab.Information.System.LIS.Service.PhysiciansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/LIS")
public class PatientsController {

    @Autowired
    PatientsService patientsService;

    @Autowired
    PhysiciansService physiciansService;


    @GetMapping("/allPatients")
    public String viewAllPatient(Model model, @Param("keyword") String keyword) {

            List<Patients> listpatients = patientsService.getAllPatients(keyword);

            model.addAttribute("listpatients", listpatients);
            model.addAttribute("keyword", keyword);

        return "PatientsList.html";
    }

    @GetMapping("/patient/new")
    public String addPatient(Model model, RedirectAttributes ra){
        List<Physicians> physicians = physiciansService.getAllPhysicians();
        model.addAttribute("physician", physicians);
        model.addAttribute("pageTitle", "Add New Patient");
        ra.addFlashAttribute("message", "The Patient has been saved Successfully.");
        model.addAttribute("patient", new Patients());
        return "newPatient.html";
    }
    @PostMapping("/patient/save")
    public String AddOrUpdate(Patients patient){
        patientsService.addOrUpdatePatient(patient);

        return "redirect:/LIS";
    }


}
