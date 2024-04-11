package com.Lab.Information.System.LIS.Controller;

import com.Lab.Information.System.LIS.Entity.Physicians;
import com.Lab.Information.System.LIS.Service.PhysiciansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/LIS")
public class PhysiciansController {

    @Autowired
    PhysiciansService physiciansService;

    @GetMapping("/allPhysicians")
    public String allPhysicians(Model model) {
        List<Physicians> physicians = physiciansService.getAllPhysicians();
        model.addAttribute("phys", physicians);
        return "PhysiciansList.html";
    }

    @GetMapping("/physician/new")
    public String addNewPhy(Model model, RedirectAttributes ra) {
        model.addAttribute("pageTitle", "Add New Physician");
        model.addAttribute("phys", new Physicians());
        return "newphysician.html";
    }

    @PostMapping("/physician/save")
    public String AddOrUpdatePhy(Physicians phy) {
        physiciansService.addOrUpdatePhysician(phy);

        return "redirect:/LIS/allPhysicians";
    }

    @GetMapping("physician/edit/{id}")
    public String getPhyById(@PathVariable("id") int phyId, Model model, RedirectAttributes ra) {
        try {
            Physicians phys = physiciansService.getPhysicianById(phyId);
            model.addAttribute("phys", phys);
            model.addAttribute("pageTitle", "Edit User (ID: " + phyId + " )");
            return "newphysician.html";
        } catch (Exception e) {
            ra.addFlashAttribute("message", "The Patient has been saved Successfully");

            return "redirect:/LIS/allPhysicians";
        }

    }
}
