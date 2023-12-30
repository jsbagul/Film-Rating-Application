package org.DTO;

public class Film {
    private int filmId;
    private String filmName;
    private int filmYear;
    private String fimlLang;
    private double filmRating;

    public Film() {
    }

    public Film(String filmName, int filmYear, String fimlLang, double filmRating) {
        this.filmName = filmName;
        this.filmYear = filmYear;
        this.fimlLang = fimlLang;
        this.filmRating = filmRating;
    }

    public Film(int filmId, String filmName, int filmYear, String fimlLang, double filmRating) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.filmYear = filmYear;
        this.fimlLang = fimlLang;
        this.filmRating = filmRating;
    }


    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getFilmYear() {
        return filmYear;
    }

    public void setFilmYear(int filmYear) {
        this.filmYear = filmYear;
    }

    public String getFimlLang() {
        return fimlLang;
    }

    public void setFimlLang(String fimlLang) {
        this.fimlLang = fimlLang;
    }

    public double getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(double filmRating) {
        this.filmRating = filmRating;
    }
}

