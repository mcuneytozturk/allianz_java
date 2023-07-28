import model.*;
import model.Character;
import service.GameService;
import service.LoadService;
import service.PlayerService;
import service.WeatherService;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        LoadService loadService = new LoadService();
        PlayerService playerService = new PlayerService();
        GameService gameService = new GameService();
        WeatherService weatherService = new WeatherService();
        //Initialize Game
        ArrayList<Character> characterList = loadService.loadCharacters();
        ArrayList<Pokemon> pokemonList =  loadService.loadPokemons();


        Player player1 = loadService.createPlayer(characterList, playerService, sc);
        Player player2 = loadService.createPlayer(characterList, playerService, sc);

        System.out.println(player1 + "\n" + player2);

        System.out.println("--Pokemon seçimi--");
        loadService.pokeChoice(sc, pokemonList, player1);
        loadService.pokeChoice(sc, pokemonList, player2);
        if(random.nextInt(10) < 5){
            System.out.println(player1.getName() + " başlıyor");
            gameService.choice(sc, player1, player2);
        } else {
            System.out.println(player2.getName() + " başlıyor");
            gameService.choice(sc, player2, player1);
        }
    }
}