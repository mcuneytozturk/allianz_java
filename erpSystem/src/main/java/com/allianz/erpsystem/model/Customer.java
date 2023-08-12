package com.allianz.erpsystem.model;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private String name;
    private List<Order> orderList;
}
