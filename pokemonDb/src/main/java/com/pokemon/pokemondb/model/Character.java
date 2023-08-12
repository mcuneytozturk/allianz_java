package com.pokemon.pokemondb.model;

import java.util.UUID;

public class Character {
    private UUID uuid;
    private String name;
    private String specialPower;

    public Character(){
        this.uuid = UUID.randomUUID();
    }
}
