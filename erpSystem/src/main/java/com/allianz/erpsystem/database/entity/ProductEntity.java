package com.allianz.erpsystem.database.entity;

import com.allianz.erpsystem.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "products")
@AttributeOverride(
        name = "uuid",
        column = @Column(
                name = "product_uuid"
        )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends BaseEntity {
    @Column(name = "product_name")
    private String name;

    @Column(name = "stock_count")
    private int stockCount;

    @Column(name = "product_detail")
    private String productDetail;

    @OneToMany(mappedBy = "product")
    private List<OrderEntity> orders;
}

