package com.pokemon.pokemondb.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Pokemon {
    private UUID uuid;
    private String name;
    private int health;
    private int damage;
    private String type;
    private String SpecialPower;

    public Pokemon(){
        this.uuid = UUID.randomUUID();
    }
}

