package assets;

import model.Film;

import java.util.ArrayList;
import java.util.List;

import model.Category;

public class movieCodes {
    public static void initializeMovies() {

        //bu kısım burdaki kod bloğunda hata almamak adına eklenmiştir

        Category categorySciFi = new Category();
        categorySciFi.setCategoryName("SciFi");

        Category categoryAdventure = new Category();
        categoryAdventure.setCategoryName("Adventure");

        Category categoryFantasy = new Category();
        categoryFantasy.setCategoryName("Fantasy");

        Category categoryHorror = new Category();
        categoryHorror.setCategoryName("Horror");

        Category categoryComedy = new Category();
        categoryComedy.setCategoryName("Comedy");

        Category categoryRomance = new Category();
        categoryRomance.setCategoryName("Romance");

        List<String> platforms = new ArrayList<>();

        platforms.add("Netflix");
        platforms.add("Disney+");
        platforms.add("PrimeTv");
        platforms.add("HboMax");
        platforms.add("PuhuTv");
        platforms.add("BluTv");

        Film avengersMovie = new Film("Avengers", 2012, "Joss Whedon", "Robert Downey Jr.", "Chris Evans", 8);
        avengersMovie.setCategories(categoryAdventure);
        categoryAdventure.addFilm(avengersMovie);
        avengersMovie.setCategories(categorySciFi);
        categorySciFi.addFilm(avengersMovie);

        Film avengers2Movie = new Film("Avengers: İnfinity War", 2012, "Joss Whedon", "Robert Downey Jr.",
                "Chris Evans", 8);
        avengers2Movie.setCategories(categoryAdventure);
        categoryAdventure.addFilm(avengers2Movie);
        avengers2Movie.setCategories(categorySciFi);
        categorySciFi.addFilm(avengers2Movie);

        Film avengers3Movie = new Film("Avengers: Endgame", 2012, "Joe&Anthony Russo", "Robert Downey Jr.",
                "Chris Evans", 8);
        avengers3Movie.setCategories(categoryAdventure);
        categoryAdventure.addFilm(avengers3Movie);
        avengers3Movie.setCategories(categorySciFi);
        categorySciFi.addFilm(avengers3Movie);

        Film lotr1Movie = new Film("Lord of the Rings: The Fellowship of the Ring ", 2001, "Peter Jackson",
                "Elijah Wood", "Viggo Mortensen", 8.9);
        lotr1Movie.setCategories(categoryAdventure);
        categoryAdventure.addFilm(lotr1Movie);
        lotr1Movie.setCategories(categoryFantasy);
        categoryFantasy.addFilm(lotr1Movie);

        Film lotr2Movie = new Film("Lord of the Rings: Two Tower", 2002, "Peter Jackson", "Elijah Wood",
                "Viggo Mortensen", 8.9);
        lotr2Movie.setCategories(categoryAdventure);
        categoryAdventure.addFilm(lotr2Movie);
        lotr2Movie.setCategories(categoryFantasy);
        categoryFantasy.addFilm(lotr2Movie);

        Film lotr3Movie = new Film("Lord of the Rings: Return of the King ", 2003, "Peter Jackson", "Elijah Wood",
                "Viggo Mortensen", 8.9);
        lotr3Movie.setCategories(categoryAdventure);
        categoryAdventure.addFilm(lotr3Movie);
        lotr3Movie.setCategories(categoryFantasy);
        categoryFantasy.addFilm(lotr3Movie);

        Film redeemingLoveMovie = new Film("Redeeming Love", 2022, "D.J. Caruso", "Abigail Cowen", "Tom Lewis", 6.7);
        redeemingLoveMovie.setCategories(categoryRomance);
        categoryRomance.addFilm(redeemingLoveMovie);

        Film atsMovie = new Film("Aşk Tesadüfleri Sever", 2011, "Ömer Faruk Sorak", "Mehmet Günsür", "Belçim Bilgin",
                7.4);
        atsMovie.setCategories(categoryRomance);
        categoryRomance.addFilm(atsMovie);

        Film sawMovie = new Film("Saw", 2004, "James Wan", "Tobin sell", "Cary Elwes", 7.6);
        sawMovie.setCategories(categoryHorror);
        categoryHorror.addFilm(sawMovie);

        Film saw2Movie = new Film("Saw II", 2005, "James Wan", "Tobin sell", "Donnie Wahlberg", 7.6);
        saw2Movie.setCategories(categoryHorror);
        categoryHorror.addFilm(saw2Movie);

        Film goraMovie = new Film("G.O.R.A", 2004, "Cem Yılmaz & Ömer Faruk Sorak", "Cem Yılmaz", "Ozan Güven", 10.0);
        goraMovie.setCategories(categoryComedy);
        categoryComedy.addFilm(goraMovie);

        Film arogMovie = new Film("A.R.O.G", 2004, "Cem Yılmaz & Ali Taner Baltacı", "Cem Yılmaz", "Ozan Güven", 10.0);
        arogMovie.setCategories(categoryComedy);
        categoryComedy.addFilm(arogMovie);
    }
}
