package com.Lab.Information.System.LIS.Service;

import com.Lab.Information.System.LIS.Entity.Order_List;
import com.Lab.Information.System.LIS.Entity.Orders;
import com.Lab.Information.System.LIS.Entity.Patients;
import com.Lab.Information.System.LIS.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    OrderListService orderListService;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    PatientsService patientsService;

    public void saveOrders(int orderId, int pat_Id) {
        Patients patientById = patientsService.getPatientById(pat_Id);

        Order_List orderListById = orderListService.getOrderListById(orderId);

        Orders orders = new Orders(orderListById, patientById, LocalDate.now());
        ordersRepository.save(orders);


    }

    public void deleteOrder(int orderId) {
        ordersRepository.findById(orderId).ifPresent(byId -> ordersRepository.delete(byId));
    }
}
