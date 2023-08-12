package com.allianz.erpsystem.service;

import com.allianz.erpsystem.database.entity.BillEntity;
import com.allianz.erpsystem.database.entity.OrderEntity;
import com.allianz.erpsystem.database.repository.BillEntityRepository;
import com.allianz.erpsystem.model.KDV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    BillEntityRepository billEntityRepository;

    public BillEntity createBill(OrderEntity order, int orderAmount, int price, KDV kdv){
        BillEntity bill = new BillEntity();
        bill.setOrder(order);
        bill.setOrderAmount(orderAmount);
        bill.setPrice(price);
        bill.setFinalPrice(price * kdv.getKdv());

        billEntityRepository.save(bill);

        return bill;
    }
}
