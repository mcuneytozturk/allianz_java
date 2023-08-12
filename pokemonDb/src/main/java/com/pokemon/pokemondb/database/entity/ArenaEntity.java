package com.pokemon.pokemondb.database.entity;

import com.pokemon.pokemondb.util.dbutil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@AttributeOverride(
        name="uuid",
        column = @Column(
                name = "arena_uuid"
        )
)
@Data
public class ArenaEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String champion;
    @Column
    private String type;
}
