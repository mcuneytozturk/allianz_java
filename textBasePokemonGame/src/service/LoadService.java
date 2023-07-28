package service;

import model.*;
import model.Character;

import java.util.ArrayList;
import java.util.Scanner;

public class LoadService{

    public ArrayList<Character> loadCharacters(){
        SpecialPower strategy1 = new Strategy("Strategy", 4, 1);
        SpecialPower strategy2 = new Strategy("Strategy II", 3, 1);

        Character ash = new Ash("Ash", strategy1);
        Character brooke = new Brooke("Brooke", strategy2);

        ArrayList<Character> characterList = new ArrayList<>();
        characterList.add(ash);
        characterList.add(brooke);
        return characterList;
    }
    public ArrayList<Pokemon> loadPokemons(){
        ArrayList<Pokemon> pokemonList = new ArrayList<>();

        SpecialPower electricity = new Electricty("Electricty", 3, 3);
        SpecialPower water = new Water("Water", 1, 3);
        SpecialPower fire = new Fire("Fire", 5, 3);
        SpecialPower earth = new Earth("Earth", 4, 3);

        Pokemon pokemon1 = new Pikachu("Pikachu", 18, 10, TypeEnum.ELECTRICY, electricity);
        Pokemon pokemon2 = new Sqiurtle("Squirtle", 20, 8, TypeEnum.WATER, water);
        Pokemon pokemon3 = new Charmander("Charmender", 17, 12, TypeEnum.FIRE, fire);
        Pokemon pokemon4 = new Balbausar("Balbausar", 22, 7, TypeEnum.EARTH, earth);

        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
        pokemonList.add(pokemon3);
        pokemonList.add(pokemon4);

        return pokemonList;
    }

    public void pokeChoice(Scanner sc, ArrayList<Pokemon> pokemonList, Player player2) {
        int pokeIndex;
        System.out.println("------Pokemons------");
        for (int i = 0; i < pokemonList.size(); i++){
            System.out.println((i + 1) + ". " + pokemonList.get(i) );
        }
        System.out.println(player2.getName() + ", 1. pokemonunuzu seçin");
        pokeIndex = sc.nextInt() - 1;
        player2.getCharacter().getPokemonList().add(pokemonList.get(pokeIndex));
        System.out.println("2. pokemonunuzu seçin");
        pokeIndex = sc.nextInt() - 1;
        player2.getCharacter().getPokemonList().add(pokemonList.get(pokeIndex));
    }

    public Player createPlayer(ArrayList<Character> characterList, PlayerService playerService, Scanner sc){
        String name;
        int temp;
        System.out.println("Adınızı giriniz: ");
        name = sc.next();
        System.out.println(name + ", karakterinizi seçiniz");
        System.out.println("------Characters------");
        for (int i = 0; i < characterList.size(); i++) {
            System.out.println((i + 1) + " - " + characterList.get(i).toString());
        }
        temp = sc.nextInt() - 1 ;
        return playerService.createPlayer(name, characterList.get(temp));
    }

}
