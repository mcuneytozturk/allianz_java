package com.pokemon.pokemondb.database.entity;

import com.pokemon.pokemondb.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@AttributeOverride(
        name="uuid",
        column = @Column(
                name = "pokemon_uuid"
        )
)
@Data
public class PokemonEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private int health;
    @Column
    private int damage;
    @Column
    private String type;
    @Column
    private String specialPower;
}
