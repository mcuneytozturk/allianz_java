package com.allianz.erpsystem.service;

import com.allianz.erpsystem.database.entity.CustomerEntity;
import com.allianz.erpsystem.database.repository.CustomerEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    CustomerEntityRepository customerEntityRepository;

    public CustomerEntity createCustomer(CustomerEntity customer){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customer.getName());

        customerEntityRepository.save(customerEntity);

        return customerEntity;
    }

    public CustomerEntity getCustomerByUuid(UUID uuid){
        Optional<CustomerEntity> customer = customerEntityRepository.findByUuid(uuid);

        return customer.orElse(null);
    }

    @Transactional
    public CustomerEntity updateCustomerByUuid(UUID uuid, CustomerEntity customer){
        CustomerEntity customer1 = getCustomerByUuid(uuid);

        if(customer1 != null){
            customer1.setName(customer.getName());

            customerEntityRepository.save(customer1);

            return customer1;
        } else {
            return null;
        }
    }
}
