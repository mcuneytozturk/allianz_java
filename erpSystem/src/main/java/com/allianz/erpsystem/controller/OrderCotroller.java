package com.allianz.erpsystem.controller;

import com.allianz.erpsystem.database.entity.BillEntity;
import com.allianz.erpsystem.database.entity.OrderEntity;
import com.allianz.erpsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class OrderCotroller {
    @Autowired
    OrderService orderService;

    @GetMapping("order/{uuid}")
    public ResponseEntity<OrderEntity> getOrder(@PathVariable UUID uuid){
        return new ResponseEntity<>(orderService.getOrderByUUID(uuid), HttpStatus.OK);
    }

    @PostMapping("order")
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity order){
        OrderEntity order1 = orderService.createOrder(order.getDecreaseAmount());
        return new ResponseEntity<>(order1, HttpStatus.CREATED);
    }

    @PutMapping("accept-order/{uuid}")
    public ResponseEntity<BillEntity> acceptOrderByUUID(@PathVariable UUID uuid){
        BillEntity bill = orderService.acceptOrderByUuid(uuid);

        return new ResponseEntity<>(bill, HttpStatus.ACCEPTED);

    }
}
