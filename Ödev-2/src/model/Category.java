package model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String categoryName;
    private List<String> filmList = new ArrayList<>(); 

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

    public List<String> getFilmList() {
        return filmList;
    }

    public void addFilm(Film film){
        filmList.add(film.toString());
    }

    @Override
    public String toString() {
        return "Category: " + categoryName + "( " + filmCount + " )";
    }


    
}
