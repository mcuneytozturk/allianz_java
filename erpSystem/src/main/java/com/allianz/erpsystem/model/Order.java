package com.allianz.erpsystem.model;

import com.allianz.erpsystem.model.enums.StatusEnum;
import lombok.Data;

import java.util.Set;

@Data
public class Order {
    private int decreaseAmount;
    private StatusEnum statusEnum;
    private double finalPrice;
}
