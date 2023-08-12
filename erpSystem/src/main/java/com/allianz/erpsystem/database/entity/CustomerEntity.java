package com.allianz.erpsystem.database.entity;

import com.allianz.erpsystem.util.dbUtil.BaseEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="customers")
@AttributeOverride(
        name ="uuid",
        column = @Column(
                name = "customer_uuid"
        )
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity extends BaseEntity {
    @Column
    private String name;

}
