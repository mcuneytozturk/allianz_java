package com.pokemon.pokemondb.controller;

import com.pokemon.pokemondb.model.Arena;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("arena")
public class ArenaController {
    @GetMapping()
    public ResponseEntity<Arena> getArena(){
        Arena arena = new Arena();

        arena.setName("Pewter City Gym");
        arena.setType("Rock");
        arena.setChampion("Brock");

        return new ResponseEntity<>(arena, HttpStatus.OK);
    }
}
