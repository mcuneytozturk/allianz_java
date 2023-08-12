package com.allianz.erpsystem.model;

import lombok.Data;


@Data
public class Product {
    private String name;

    private int stockCount;

    private String productDetail;
}
