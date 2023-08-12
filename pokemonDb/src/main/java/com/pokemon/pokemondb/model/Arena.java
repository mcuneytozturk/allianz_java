package com.pokemon.pokemondb.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Arena {
    private UUID uuid;
    private String name;
    private String champion;
    private String type;

    public Arena(){
        this.uuid = UUID.randomUUID();
    }

}
