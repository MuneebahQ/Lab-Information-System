package com.Lab.Information.System.LIS.Controller;

import com.Lab.Information.System.LIS.Entity.Order_List;
import com.Lab.Information.System.LIS.Entity.Orders;
import com.Lab.Information.System.LIS.Entity.Patients;
import com.Lab.Information.System.LIS.Repository.OrdersRepository;
import com.Lab.Information.System.LIS.Service.OrderListService;
import com.Lab.Information.System.LIS.Service.OrdersService;
import com.Lab.Information.System.LIS.Service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/LIS")
public class OrdersController {

    @Autowired
    OrderListService orderListService;
    @Autowired
    OrdersService ordersService;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    PatientsService patientsService;
    int pat_Id;

    @GetMapping("/addOrder/pat_id/{patId}")
    private String addOrderPage(@PathVariable int patId, Model model){
        pat_Id = patId;
        List<Order_List> fullOrderList = orderListService.getFullOrderList();

        model.addAttribute("fullOrderList", fullOrderList);

        return "addOrder.html";
    }

    @PostMapping("/save/order/{orderId}")
    private String saveOrder(@PathVariable int orderId){

        ordersService.saveOrders(orderId, pat_Id);

        return "addOrder.html";
    }

    @GetMapping("/allOrders/patId/{patId}")
    private String allOrders(@PathVariable int patId, Model model){
        Patients patientById = patientsService.getPatientById(patId);
        List<Orders> byPatId = ordersRepository.findByPatId(patientById);

        model.addAttribute("orders", byPatId);
        return "AllOrders.html";
    }

    @DeleteMapping("/order/delete/orderId/{orderId}")
    private void deleteOrder(@PathVariable int orderId){
        ordersService.deleteOrder(orderId);
    }
}
