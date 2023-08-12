package com.pokemon.pokemondb.service;

import com.pokemon.pokemondb.model.Arena;

public class ArenaService {
    public Arena createArena(String name, String champion, String type){
        Arena arena = new Arena();
        arena.setName(name);
        arena.setType(type);
        arena.setChampion(champion);

        return arena;
    }
}
