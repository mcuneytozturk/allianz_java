package com.allianz.erpsystem.model;

import lombok.Data;

@Data
public class
Bill {
    private Product product;
    private int orderAmount;
    private int price;
    private KDV kdv;
    private int finalPrice;

}
