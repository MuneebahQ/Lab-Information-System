package com.Lab.Information.System.LIS.Service;

import com.Lab.Information.System.LIS.Entity.Order_List;
import com.Lab.Information.System.LIS.Repository.Order_ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderListService {

    @Autowired
    private Order_ListRepository orderListRepo;

    public List<Order_List> getFullOrderList() {
        return orderListRepo.findAll();
    }

    public Order_List addOrUpdateOrderList(Order_List list) {
        return orderListRepo.save(list);

    }

    public Order_List getOrderListById(int listId) {
        return orderListRepo.findById(listId).orElse(null);
    }

}
