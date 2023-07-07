package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Film {
    private String filmName;

    private int year;

    private String director;

    private String star;

    private String coStar;

    private ArrayList<Category> categories = new ArrayList<>();

    private  ArrayList<String> platforms = new ArrayList<>();

    private double imdbScore;

    private String[] sessions = {"09:00", "11:00", "13:00", "15:00", "17:00", "19:00"};

    public Film(String filmName, int year, String director, String star, String coStar, double imdbScore) {
        this.filmName = filmName;
        this.year = year;
        this.director = director;
        this.star = star;
        this.coStar = coStar;
        this.imdbScore = imdbScore;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getCoStar() {
        return coStar;
    }

    public void setCoStar(String coStar) {
        this.coStar = coStar;
    }

    public void setCategories(Category category) {
        this.categories.add(category);
        category.setFilmCount();
    }

    public void setPlatforms(String platform) {
        this.platforms.add(platform);
    }

    public double getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(double imdbScore) {
        this.imdbScore = imdbScore;
    }

    public String[] getSessions() {
        return sessions;
    }

    public void setSessions(String[] sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "Film: \n Name= " + filmName + "\n Publish year= " + year + "\n Director= " + director + "\n Star= " + star
                + "\n Co-Star= " + coStar + "\n Categories= " + categories.toString() + "\n Platforms= " + platforms.toString()
                + "\n Imdb-Score= " + imdbScore + "\n Sessions= " + Arrays.toString(sessions);
    }



}
