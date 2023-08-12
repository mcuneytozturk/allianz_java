package com.allianz.erpsystem.database.entity;

import com.allianz.erpsystem.model.enums.StatusEnum;
import com.allianz.erpsystem.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="orders")
@AttributeOverride(
        name = "uuid",
        column = @Column (
                name= "order_uuid"
        )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends BaseEntity {
    @ManyToOne(targetEntity = ProductEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private ProductEntity product;


    @OneToOne(mappedBy = "bills")
    private OrderEntity order;

    @Column
    private int decreaseAmount;

    @Column
    private StatusEnum statusEnum;

    @Column
    private int price;

}
