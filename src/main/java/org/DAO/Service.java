package org.DAO;

import org.DTO.Film;

import java.util.List;

public interface Service {
    public int giveRating(Film film);
    public int updateFilmYear(int filmYear,String filmName);
    public List<Film> goodFilms();
    public List<Film> nominate();

    public String getMovieName(int id);

    public List<Film> displayMovies();

}
