package com.allianz.erpsystem.database.entity;

import com.allianz.erpsystem.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "bills")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "bill_uuid"
        )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillEntity extends BaseEntity {
    @OneToOne(targetEntity = OrderEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @Column(name = "order_amount", nullable = false)
    private int orderAmount;

    @Column(name = "price")
    private int price;

    @Column(name = "final_price")
    private double finalPrice;

}
