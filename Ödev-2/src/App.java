import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Category;
import model.Film;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

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

        String[] avengersPlatforms = new String[1];
        avengersPlatforms[0] = platforms.get(1);
        avengersMovie.setPlatforms(avengersPlatforms);

        Film avengers2Movie = new Film("Avengers: İnfinity War", 2012, "Joss Whedon", "Robert Downey Jr.",
                "Chris Evans", 8);
        avengers2Movie.setCategories(categoryAdventure);
        categoryAdventure.addFilm(avengers2Movie);
        avengers2Movie.setCategories(categorySciFi);
        categorySciFi.addFilm(avengers2Movie);

        String[] avengers2Platforms = new String[1];
        avengers2Platforms[0] = platforms.get(1);
        avengers2Movie.setPlatforms(avengers2Platforms);

        Film avengers3Movie = new Film("Avengers: Endgame", 2012, "Joe&Anthony Russo", "Robert Downey Jr.",
                "Chris Evans", 8);
        avengers3Movie.setCategories(categoryAdventure);
        categoryAdventure.addFilm(avengers3Movie);
        avengers3Movie.setCategories(categorySciFi);
        categorySciFi.addFilm(avengers3Movie);

        String[] avengers3Platforms = new String[1];
        avengers3Platforms[0] = platforms.get(1);
        avengers3Movie.setPlatforms(avengers3Platforms);

        Film lotr1Movie = new Film("Lord of the Rings: The Fellowship of the Ring ", 2001, "Peter Jackson",
                "Elijah Wood", "Viggo Mortensen", 8.9);
        lotr1Movie.setCategories(categoryAdventure);
        categoryAdventure.addFilm(lotr1Movie);
        lotr1Movie.setCategories(categoryFantasy);
        categoryFantasy.addFilm(lotr1Movie);

        String[] lotr1Platforms = new String[1];
        lotr1Platforms[0] = platforms.get(0);
        lotr1Movie.setPlatforms(lotr1Platforms);

        Film lotr2Movie = new Film("Lord of the Rings: Two Tower", 2002, "Peter Jackson", "Elijah Wood",
                "Viggo Mortensen", 8.9);
        lotr2Movie.setCategories(categoryAdventure);
        categoryAdventure.addFilm(lotr2Movie);
        lotr2Movie.setCategories(categoryFantasy);
        categoryFantasy.addFilm(lotr2Movie);

        String[] lotr2Platforms = new String[1];
        lotr2Platforms[0] = platforms.get(1);
        lotr2Movie.setPlatforms(lotr2Platforms);

        Film lotr3Movie = new Film("Lord of the Rings: Return of the King ", 2003, "Peter Jackson", "Elijah Wood",
                "Viggo Mortensen", 8.9);
        lotr3Movie.setCategories(categoryAdventure);
        categoryAdventure.addFilm(lotr3Movie);
        lotr3Movie.setCategories(categoryFantasy);
        categoryFantasy.addFilm(lotr3Movie);

        String[] lotr3Platforms = new String[1];
        lotr3Platforms[0] = platforms.get(1);
        lotr3Movie.setPlatforms(lotr3Platforms);

        Film redeemingLoveMovie = new Film("Redeeming Love", 2022, "D.J. Caruso", "Abigail Cowen", "Tom Lewis", 6.7);
        redeemingLoveMovie.setCategories(categoryRomance);
        categoryRomance.addFilm(redeemingLoveMovie);

        String[] redeemingLoveMoviePlat = new String[1];
        redeemingLoveMoviePlat[0] = platforms.get(3);
        redeemingLoveMovie.setPlatforms(redeemingLoveMoviePlat);

        Film atsMovie = new Film("Aşk Tesadüfleri Sever", 2011, "Ömer Faruk Sorak", "Mehmet Günsür", "Belçim Bilgin",
                7.4);
        atsMovie.setCategories(categoryRomance);
        categoryRomance.addFilm(atsMovie);

        String[] atsPlat = new String[1];
        atsPlat[0] = platforms.get(3);
        atsMovie.setPlatforms(atsPlat);

        Film sawMovie = new Film("Saw", 2004, "James Wan", "Tobin sell", "Cary Elwes", 7.6);
        sawMovie.setCategories(categoryHorror);
        categoryHorror.addFilm(sawMovie);

        String[] sawPlat = new String[1];
        sawPlat[0] = platforms.get(0);
        sawMovie.setPlatforms(sawPlat);

        Film saw2Movie = new Film("Saw II", 2005, "James Wan", "Tobin sell", "Donnie Wahlberg", 7.6);
        saw2Movie.setCategories(categoryHorror);
        categoryHorror.addFilm(saw2Movie);

        String[] saw2Plat = new String[1];
        saw2Plat[0] = platforms.get(2);
        saw2Movie.setPlatforms(saw2Plat);

        Film goraMovie = new Film("G.O.R.A", 2004, "Cem Yılmaz & Ömer Faruk Sorak", "Cem Yılmaz", "Ozan Güven", 10.0);
        goraMovie.setCategories(categoryComedy);
        categoryComedy.addFilm(goraMovie);

        String[] goraMoviePlat = new String[1];
        goraMoviePlat[0] = platforms.get(5);
        goraMovie.setPlatforms(goraMoviePlat);

        Film arogMovie = new Film("A.R.O.G", 2004, "Cem Yılmaz & Ali Taner Baltacı", "Cem Yılmaz", "Ozan Güven", 10.0);
        arogMovie.setCategories(categoryComedy);
        categoryComedy.addFilm(arogMovie);

        String[] arogMoviePlat = new String[1];
        arogMoviePlat[0] = platforms.get(5);
        arogMovie.setPlatforms(arogMoviePlat);

        System.out.println("Hoşgeldiniz");

        int type;

        do {
            System.out.println("1 -  Admin Girişi\n2 - Kullanıcı Girişi\n 0 - Çıkış");
            type = scanner.nextInt();

            switch (type) {
                case 1:

                    System.out.println("Merhaba admin\nYeni film ekleme sayfasına hoş geldiniz.");
                    System.out.print("Filmin adını giriniz; ");
                    String name = scanner.nextLine();
                    scanner.nextLine();

                    System.out.print("Filmin çıkış yılını giriniz; ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Filmin yönetmenini giriniz; ");
                    String director = scanner.nextLine();

                    System.out.print("Filmin başrol oyuncusunu giriniz; ");
                    String star = scanner.nextLine();

                    System.out.print("Filmin yardımcı oyuncusunu giriniz; ");
                    String coStar = scanner.nextLine();

                    System.out.print("Filmin IMDB puanını giriniz; ");
                    double imdbScore = scanner.nextDouble();
                    scanner.nextLine();

                    Film newFilm = new Film(name, year, director, star, coStar, imdbScore);

                    int categoryAmount;

                    System.out.println("Filmin kategori sayısını girin: ");
                    categoryAmount = scanner.nextInt();
                    scanner.nextLine();
                    int temp;

                    for (int i = 0; i < categoryAmount; i++) {
                        System.out.println(
                                "Kategori numarasını girin:\n 1. SciFi\n2. Adventure\n3.Fantasy\n4. Romance \n5.Comedy\n6.Horror");
                        temp = scanner.nextInt();
                        switch (temp) {
                            case 1:
                                newFilm.setCategories(categorySciFi);
                                break;
                            case 2:
                                newFilm.setCategories(categoryAdventure);
                                break;
                            case 3:
                                newFilm.setCategories(categoryFantasy);
                                break;
                            case 4:
                                newFilm.setCategories(categoryRomance);
                                break;
                            case 5:
                                newFilm.setCategories(categoryComedy);
                                break;
                            case 6:
                                newFilm.setCategories(categoryHorror);
                                break;
                        }
                    }

                    break;
                case 2:
                    int categoryNum = -1;
                    System.out.println("Görmek istediğiniz kategori numarasını tuşlayınız:");
                    System.out.println("1 - " + categoryHorror.toString());
                    System.out.println("2 - " + categoryAdventure.toString());
                    System.out.println("3 - " + categoryFantasy.toString());
                    System.out.println("4 - " + categoryComedy.toString());
                    System.out.println("5 - " + categorySciFi.toString());
                    System.out.println("6 - " + categoryRomance.toString());
                    System.out.println("Çıkış için 0 tuşlayınız");
                    categoryNum = scanner.nextInt();
                    scanner.nextLine();

                    switch (categoryNum) {
                        case 1:
                            List<String> horrorFilms = categoryHorror.getFilmList();
                            for (String film : horrorFilms) {
                                System.out.println(film);
                            }
                        case 2:
                            List<String> adventureFilms = categoryAdventure.getFilmList();
                            for (String film : adventureFilms) {
                                System.out.println(film);
                                break;
                            }
                        case 3:
                            List<String> fantasyFilms = categoryFantasy.getFilmList();
                            for (String film : fantasyFilms) {
                                System.out.println(film);
                            }
                            break;
                        case 4:
                            List<String> comedyFilms = categoryComedy.getFilmList();
                            for (String film : comedyFilms) {
                                System.out.println(film);
                            }
                            break;
                        case 5:
                            List<String> sciFiFilms = categorySciFi.getFilmList();
                            for (String film : sciFiFilms) {
                                System.out.println(film);
                            }
                            break;
                            case 6:
                            List<String> romanceFilms = categoryRomance.getFilmList();
                            for (String film : romanceFilms) {
                                System.out.println(film);
                            }
                            break;
                    }
                    break;
                case 0:
                    type = 0;

            }
        } while (type != 0);
    }
}
