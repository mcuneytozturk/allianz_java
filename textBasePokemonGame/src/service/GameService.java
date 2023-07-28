package service;

import model.Player;
import model.Pokemon;
import model.SpecialPower;
import model.Weather;

import java.util.Scanner;

public class GameService {
    WeatherService weatherService = new WeatherService();
    LoadService loadService = new LoadService();

    /*ödevde ana savaş bu method üzerinden işliyor
            - önce her bir choice metodu için weatherService ile yeni bir weather seçiliyor,
            - yine weather servisinden decreaseDmg fonksiyonu çağrılarak oyundaki tüm pokemonların dmg'i yeniden belirleniyor
            - saldırı, pokemon özel gücü ve karakter özel gücü ile mi saldıralacağı soruluyor
            - 

     */
    public void choice(Scanner sc, Player player1, Player player2) {
        Weather weather = weatherService.createWeather();
        weatherService.decreaseDmgs(loadService, weather);
        System.out.println("Hava durumu => " + weather);
        System.out.println(player1.getName() + " saldırıyor.");
        System.out.println("1. Saldırı \n 2. Pokemon özel gücü \n 3. Karakter özel gücü");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> attack(player1, player2);
            case 2 -> pokemonSpecialAttack(player1, player2);
            case 3 -> characterSpecialAttack(player1, player2);
        }
        for (Pokemon pokemon: player1.getCharacter().getPokemonList()){
            if(pokemon.getHealth() > 0){
                break;
            } else {
                player2.setWinner(true);
            }
        }
        for (Pokemon pokemon: player2.getCharacter().getPokemonList()){
            if(pokemon.getHealth() > 0){
                break;
            } else {
                player1.setWinner(true);
            }
        }

        if (player1.isWinner()) {
            System.out.println(player1.getName() + " kazandı");
        } else if (player2.isWinner()) {
            System.out.println(player2.getName() + " kazandı");
        } else {
            System.out.println(player1);
            System.out.println(player2);
            choice(sc, player2, player1);
        }
    }

    public void attack(Player attacker, Player defender) {
        Pokemon attackingPokemon;
        Pokemon defendingPokemon;
        if (defender.getCharacter().getPokemonList().get(0).getHealth() > 0) {
            attackingPokemon = attacker.getCharacter().getPokemonList().get(0);
            defendingPokemon = defender.getCharacter().getPokemonList().get(0);
        } else {
            attackingPokemon = attacker.getCharacter().getPokemonList().get(0);
            defendingPokemon = defender.getCharacter().getPokemonList().get(1);
        }

        defendingPokemon.setHealth(defendingPokemon.getHealth() - attackingPokemon.getDamage());
        System.out.println(defender.getName() + " savunuyor. " + defendingPokemon.getName() + " isimli pokemon " + attackingPokemon.getDamage() + "  hasar aldı ve " + defendingPokemon.getHealth() + " canı kaldı");
        if (!healthCheck(defendingPokemon)) {
            attacker.getCharacter().getPokemonList().add(takeLosingPokemon(attacker, defender));
        }

    }

    public void characterSpecialAttack(Player attacker, Player defender) {
        SpecialPower specialAttack = attacker.getCharacter().getSpecialPower();
        Pokemon attackingPokemon;
        Pokemon defendingPokemon = defender.getCharacter().getPokemonList().get(0);
        if (healthCheck(defendingPokemon)) {
            attackingPokemon = attacker.getCharacter().getPokemonList().get(0);
            defendingPokemon = defender.getCharacter().getPokemonList().get(0);
        } else {
            attackingPokemon = attacker.getCharacter().getPokemonList().get(0);
            defendingPokemon = defender.getCharacter().getPokemonList().get(1);
        }
        if (specialAttack.getRemainingRights() > 0) {
            attackingPokemon.setDamage(attackingPokemon.getDamage() + specialAttack.getExtraDamage());
            defendingPokemon.setHealth(defendingPokemon.getHealth() - attackingPokemon.getDamage());
            System.out.println(defender.getName() + " savunduğu " + defendingPokemon.getName() + " isimli pokemon " + attackingPokemon.getDamage() + " hasar aldı ve " + defendingPokemon.getHealth() + " canı kaldı");
            if (!healthCheck(defendingPokemon)) {
                attacker.getCharacter().getPokemonList().add(takeLosingPokemon(attacker, defender));
            }
            specialAttack.setRemainingRights(specialAttack.getRemainingRights() - 1);
        } else {
            defendingPokemon.setHealth(defendingPokemon.getHealth());
        }
    }

    public void pokemonSpecialAttack(Player attacker, Player defender) {
        Pokemon attackingPokemon;
        Pokemon defendingPokemon = defender.getCharacter().getPokemonList().get(0);
        if (healthCheck(defendingPokemon)) {
            attackingPokemon = attacker.getCharacter().getPokemonList().get(0);
            defendingPokemon = defender.getCharacter().getPokemonList().get(0);
        } else {
            attackingPokemon = attacker.getCharacter().getPokemonList().get(0);
            defendingPokemon = defender.getCharacter().getPokemonList().get(1);
        }

        SpecialPower specialAttack = attackingPokemon.getSpecialPower();

        if (specialAttack.getRemainingRights() > 0) {
            attackingPokemon.setDamage(attackingPokemon.getDamage() + specialAttack.getExtraDamage());
            defendingPokemon.setHealth(defendingPokemon.getHealth() - attackingPokemon.getDamage());
            System.out.println(defender.getName() + " savunuyor " + defendingPokemon.getName() + " isimli pokemon " + attackingPokemon.getDamage() + " hasar aldı ve " + defendingPokemon.getHealth() + " canı kaldı");
            if (!healthCheck(defendingPokemon)) {
                attacker.getCharacter().getPokemonList().add(takeLosingPokemon(attacker, defender));
            }
            attackingPokemon.getSpecialPower().setRemainingRights(attackingPokemon.getSpecialPower().getRemainingRights() - 1);
        } else {
            defendingPokemon.setHealth(defendingPokemon.getHealth());
        }
    }

    public boolean healthCheck(Pokemon pokemon) {
        return pokemon.getHealth() > 0;
    }

    public Pokemon takeLosingPokemon(Player attacker, Player defender) {
        Pokemon losingPokemon = defender.getCharacter().getPokemonList().get(0);
        for(Pokemon pokemon: defender.getCharacter().getPokemonList()){
            if (pokemon.getHealth() > 0){
                System.out.println(defender.getName() + ", pokemonu yenildi ve rakibe geçti." + defender.getCharacter().getPokemonList().get(1).getName() + " ile devam ediliyor");
            } else {
                System.out.println(defender.getName() + ", pokemonu yenildi");
            }
        }
        defender.getCharacter().getPokemonList().remove(losingPokemon);
        attacker.getCharacter().getPokemonList().add(losingPokemon);
        return losingPokemon;
    }
}
