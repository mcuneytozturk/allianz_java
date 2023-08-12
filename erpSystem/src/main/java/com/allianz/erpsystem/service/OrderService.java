package com.allianz.erpsystem.service;

import com.allianz.erpsystem.database.entity.BillEntity;
import com.allianz.erpsystem.database.entity.OrderEntity;
import com.allianz.erpsystem.database.entity.ProductEntity;
import com.allianz.erpsystem.database.repository.BillEntityRepository;
import com.allianz.erpsystem.database.repository.OrderEntityRepository;
import com.allianz.erpsystem.database.repository.ProductEntityRepository;
import com.allianz.erpsystem.model.KDV;
import com.allianz.erpsystem.model.Order;
import com.allianz.erpsystem.model.enums.StatusEnum;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Autowired
    ProductEntityRepository productEntityRepository;

    @Autowired
    BillService billService;

    @Autowired
    BillEntityRepository billEntityRepository;

    public OrderEntity createOrder(int amount) {
        OrderEntity order = new OrderEntity();
        order.setDecreaseAmount(amount);
        order.setStatusEnum(StatusEnum.PENDING);
        orderEntityRepository.save(order);

        return order;
    }

    public OrderEntity getOrderByUUID(UUID uuid) {
        Optional<OrderEntity> orderEntity = orderEntityRepository.findByUuid(uuid);

        return orderEntity.orElse(null);
    }

    public BillEntity acceptOrderByUuid(UUID uuid) {
        OrderEntity order = getOrderByUUID(uuid);
        KDV kdv = new KDV();
        if (order != null) {
            order.setStatusEnum(StatusEnum.ACCEPTED);

            BillEntity bill = billService.createBill(order, order.getDecreaseAmount(), order.getPrice(), kdv);

            billEntityRepository.save(bill);

            return bill;
        } else {
            return null;
        }
    }

    @Transactional
    public OrderEntity updateStatusByUUID(UUID uuid, StatusEnum statusEnum) {
        OrderEntity orderEntity = getOrderByUUID(uuid);
        if (orderEntity != null) {
            orderEntity.setStatusEnum(statusEnum);

            return orderEntity;
        } else {
            return null;
        }
    }

    @Transactional
    public boolean deleteOrderByUUID(UUID uuid) {
        OrderEntity order = getOrderByUUID(uuid);
        if (order != null) {
            orderEntityRepository.deleteByUuid(uuid);
            return true;
        } else {
            return false;
        }
    }
}
