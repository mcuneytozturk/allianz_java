import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Category;
import model.Film;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // önden film eklemek için ../assets/movieCodes.java dosyasında hazır 12 film
        // var o kodu buraya nasıl getirebilirim bilmediğim için, kodu
        // kalabalıklaştırmaması adına ve önden film eklemek ödeve dahil olmadığı için
        // orda bıraktım.
        // teşekkürlerimle

        // category'leri önden tanımlarız
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

        /**
         * platformlarda önden belirlenir ancak platform girişi ödeve dahil olmadığı
         * için
         * category seçiminde platform otomatik olarak category adı ile tanımlandı
         */

        List<String> platforms = new ArrayList<>();

        platforms.add("Horror");
        platforms.add("Adventure");
        platforms.add("Fantasy");
        platforms.add("Comedy");
        platforms.add("SciFi");
        platforms.add("Romance");

        /*
         * Bir örnek film kodu kontrol için yazıldı
         * Film exampleFilm = new Film("exampleName", 2023, "exampleDirector",
         * "examplStar", "exampleCoStar", 10);
         * exampleFilm.setCategories(categoryHorror);
         * categoryHorror.addFilm(exampleFilm);
         * exampleFilm.setPlatforms(platforms.get(0));
         * System.out.println(platforms.get(0));
         * System.out.println(exampleFilm.toString());
         */

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
                                newFilm.setCategories(categoryHorror);
                                categoryHorror.addFilm(newFilm);
                                newFilm.setPlatforms(platforms.get(0));

                                System.out.println(platforms.get(0));
                                System.out.println(newFilm.toString());
                                break;
                            case 2:
                                newFilm.setCategories(categoryAdventure);
                                categoryAdventure.addFilm(newFilm);
                                break;
                            case 3:
                                newFilm.setCategories(categoryFantasy);
                                categoryFantasy.addFilm(newFilm);
                                break;
                            case 4:
                                newFilm.setCategories(categoryComedy);
                                categoryComedy.addFilm(newFilm);
                                break;
                            case 5:
                                newFilm.setCategories(categorySciFi);
                                categorySciFi.addFilm(newFilm);
                                break;
                            case 6:
                                newFilm.setCategories(categoryRomance);
                                categoryRomance.addFilm(newFilm);
                                break;
                            default:
                                System.out.println("Yanlış sayı girdiniz en baştan deneyin");

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
                            List<Film> horrorFilms = categoryHorror.getFilmList();
                            for (Film film : horrorFilms) {
                                System.out.println(film);
                            }
                            break;
                        case 2:
                            List<Film> adventureFilms = categoryAdventure.getFilmList();
                            for (Film film : adventureFilms) {
                                System.out.println(film);
                            }
                            break;
                        case 3:
                            List<Film> fantasyFilms = categoryFantasy.getFilmList();
                            for (Film film : fantasyFilms) {
                                System.out.println(film);
                            }
                            break;
                        case 4:
                            List<Film> comedyFilms = categoryComedy.getFilmList();
                            for (Film film : comedyFilms) {
                                System.out.println(film);
                            }
                            break;
                        case 5:
                            List<Film> sciFiFilms = categorySciFi.getFilmList();
                            for (Film film : sciFiFilms) {
                                System.out.println(film);
                            }
                            break;
                        case 6:
                            List<Film> romanceFilms = categoryRomance.getFilmList();
                            for (Film film : romanceFilms) {
                                System.out.println(film);
                            }
                            break;
                        default:
                            System.out.println("Yanlış sayı girdiniz baştan deneyin");
                    }
                    break;
                case 0:
                    type = 0;

            }
        } while (type != 0);
    }
}
