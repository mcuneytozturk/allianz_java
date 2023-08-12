package com.allianz.erpsystem.controller;

import com.allianz.erpsystem.database.entity.CustomerEntity;
import com.allianz.erpsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("customer/{uuid}")
    public ResponseEntity<CustomerEntity> getCustomerByUUID(@PathVariable UUID uuid){
        CustomerEntity customer = customerService.getCustomerByUuid(uuid);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("create-customer")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer){
        CustomerEntity customer1 = customerService.createCustomer(customer);


        return new ResponseEntity<>(customer1, HttpStatus.CREATED );
    }

    @PutMapping("update-customer/{uuid}")
    public ResponseEntity<CustomerEntity> updateCustomerByUUID(@PathVariable UUID uuid, @RequestBody CustomerEntity customer){
        CustomerEntity customer1 = customerService.getCustomerByUuid(uuid);

        if(customer1 != null){
            customer1.setName(customer.getName());
            return new ResponseEntity<>(customer1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
