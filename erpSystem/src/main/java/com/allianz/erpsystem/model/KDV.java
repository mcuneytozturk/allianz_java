package com.allianz.erpsystem.model;

import lombok.Data;

@Data
public class KDV {
    private double kdv;

    public KDV(){
        this.kdv = 0.18;
    }
}
