package com.Lab.Information.System.LIS.Controller;

import com.Lab.Information.System.LIS.Entity.Order_List;
import com.Lab.Information.System.LIS.Service.OrderListService;
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
public class OrderListController {

    @Autowired
    private OrderListService orderListService;

    @GetMapping("/fullorderlist")
    public String fullOrderList(Model model){
        List<Order_List> order = orderListService.getFullOrderList();
        model.addAttribute("order", order);
        return "orderListInfo.html";
    }

    @GetMapping("/orderlist/new")
    public String addNewOrderList(Model model){
        model.addAttribute("pageTitle", "Add New Order");
        model.addAttribute("list", new Order_List());
        return "AddNewOrderList.html";
    }

    @PostMapping("/orderlist/save")
    public String AddOrUpdateOrderList(Order_List list){
        orderListService.addOrUpdateOrderList(list);

        return "redirect:/LIS/fullorderlist";
    }

    @GetMapping("orderlist/edit/{id}")
    public String getOrderListById(@PathVariable("id") int orderId, Model model, RedirectAttributes ra){
        try {
            Order_List list = orderListService.getOrderListById(orderId);
            model.addAttribute("list", list);
            model.addAttribute("pageTitle", "Edit Order (ID: "+ orderId +" )");
            return "AddNewOrderList.html";
        }
        catch (Exception e){
            ra.addFlashAttribute("message", "The Patient has been saved Successfully");

            return "redirect:/LIS/fullorderlist";
        }

    }
}
