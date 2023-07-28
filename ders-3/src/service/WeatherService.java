package service;

import model.Pokemon;
import model.TypeEnum;
import model.Weather;

import java.util.ArrayList;
import java.util.Random;

public class WeatherService {
    public Weather createWeather(){
        Random random = new Random();
        int index = random.nextInt(Weather.values().length);
        return Weather.values()[index];
    }

    public void decreaseDmgs(LoadService loadService, Weather weather){
        ArrayList<Pokemon> pokemons = loadService.loadPokemons();
        for (Pokemon pokemon: pokemons) {
            if (weather.equals(Weather.HOT)) {
                TypeEnum pokemonType = pokemon.getType();
                if (pokemonType.equals(TypeEnum.ELECTRICY)) {
                    pokemon.setDamage(pokemon.getDamage() + 2);
                }
                if (pokemonType.equals(TypeEnum.FIRE)) {
                    pokemon.setDamage(pokemon.getDamage() + 10);
                }
                if (pokemonType.equals(TypeEnum.EARTH)) {
                    pokemon.setDamage(pokemon.getDamage() - 2);
                }
                if (pokemonType.equals(TypeEnum.GRASS)) {
                    pokemon.setDamage(pokemon.getDamage() + 5);
                }
                if (pokemonType.equals(TypeEnum.WATER)) {
                    pokemon.setDamage(pokemon.getDamage() - 10);
                }
                if (pokemonType.equals(TypeEnum.WING)) {
                    pokemon.setDamage(pokemon.getDamage() - 5);
                }
            }
            if (weather.equals(Weather.SUNNY)) {
                TypeEnum pokemonType = pokemon.getType();
                if (pokemonType.equals(TypeEnum.ELECTRICY)) {
                    pokemon.setDamage(pokemon.getDamage() + 1);
                }
                if (pokemonType.equals(TypeEnum.FIRE)) {
                    pokemon.setDamage(pokemon.getDamage() + 5);
                }
                if (pokemonType.equals(TypeEnum.EARTH)) {
                    pokemon.setDamage(pokemon.getDamage() - 1);
                }
                if (pokemonType.equals(TypeEnum.GRASS)) {
                    pokemon.setDamage(pokemon.getDamage() + 3);
                }
                if (pokemonType.equals(TypeEnum.WATER)) {
                    pokemon.setDamage(pokemon.getDamage() - 5);
                }
                if (pokemonType.equals(TypeEnum.WING)) {
                    pokemon.setDamage(pokemon.getDamage() - 3);
                }
            }
            if (weather.equals(Weather.SNOW)) {
                TypeEnum pokemonType = pokemon.getType();
                if (pokemonType.equals(TypeEnum.ELECTRICY)) {
                    pokemon.setDamage(pokemon.getDamage() - 5);
                }
                if (pokemonType.equals(TypeEnum.FIRE)) {
                    pokemon.setDamage(pokemon.getDamage() - 10);
                }
                if (pokemonType.equals(TypeEnum.EARTH)) {
                    pokemon.setDamage(pokemon.getDamage() + 2);
                }
                if (pokemonType.equals(TypeEnum.GRASS)) {
                    pokemon.setDamage(pokemon.getDamage() + 10);
                }
                if (pokemonType.equals(TypeEnum.WATER)) {
                    pokemon.setDamage(pokemon.getDamage() - 10);
                }
                if (pokemonType.equals(TypeEnum.WING)) {
                    pokemon.setDamage(pokemon.getDamage() - 2);
                }
            }
            if (weather.equals(Weather.RAINY)) {
                TypeEnum pokemonType = pokemon.getType();
                if (pokemonType.equals(TypeEnum.ELECTRICY)) {
                    pokemon.setDamage(pokemon.getDamage() + 10);
                }
                if (pokemonType.equals(TypeEnum.FIRE)) {
                    pokemon.setDamage(pokemon.getDamage() - 10);
                }
                if (pokemonType.equals(TypeEnum.EARTH)) {
                    pokemon.setDamage(pokemon.getDamage() - 5);
                }
                if (pokemonType.equals(TypeEnum.GRASS)) {
                    pokemon.setDamage(pokemon.getDamage() + 1);
                }
                if (pokemonType.equals(TypeEnum.WATER)) {
                    pokemon.setDamage(pokemon.getDamage() + 10);
                }
                if (pokemonType.equals(TypeEnum.WING)) {
                    pokemon.setDamage(pokemon.getDamage() - 10);
                }
            }
        }
    }
}
