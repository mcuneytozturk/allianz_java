package model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String categoryName;
    private List<Film> filmList = new ArrayList<>(); 

    private int filmCount = 0;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getFilmCount() {
        return filmCount;
    }

    public void setFilmCount() {
        this.filmCount++;
    }

    public List<Film> getFilmList() {
        return this.filmList;
    }

    public void addFilm(Film film){
        this.filmList.add(film);
    }

    @Override
    public String toString() {
        return "Category: " + categoryName + "( " + filmCount + " )";
    }


    
}
