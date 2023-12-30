package org.DAO;

import org.DTO.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceImple implements Service{

   static Connection connection;

    static {
        String url="jdbc:mysql://localhost:3306/filmiIndian";
        try {
            connection= DriverManager.getConnection(url,"root","Redminote5@");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int giveRating(int id, double rate) {
        String query="Update filmInfo set filmRating=? where filmId=?";

        try {
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setDouble(1,rate);
            pstmt.setInt(2,id);

           return pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public int giveRating(Film film) {
        String query =" insert into filmInfo(filmName,filmYear,filmLang,filmRating) values(?,?,?,?)";

        try {
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setString(1,film.getFilmName());
            pstmt.setInt(2,film.getFilmYear());
            pstmt.setString(3,film.getFimlLang());
            pstmt.setDouble(4,film.getFilmRating());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public int updateFilmYear(int filmYear, String filmName) {
        String query="Update filmInfo set filmYear=? where filmName=?";
        try {
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setInt(1,filmYear);
            pstmt.setString(2,filmName);
           return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Film> goodFilms() {
        String query="{call goodFilms}";
        List<Film> filmList=new ArrayList<>();
        try {
            CallableStatement callableStatement=connection.prepareCall(query);
          ResultSet rs  =callableStatement.executeQuery();
          while (rs.next()){
              int id=rs.getInt(1);
              String name=rs.getString(2);
              int year=rs.getInt(3);
              String lang=rs.getString(4);
              double rate=rs.getDouble(5);

              Film film=new Film(id,name,year,lang,rate);
              filmList.add(film);
          }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return filmList;

    }

    public List<Film> nominate() {
        String query="select * from filmInfo order by filmRating desc limit 5";
        List<Film> filmList=new ArrayList<>();
        try {
            Statement statement=connection.createStatement();
           ResultSet rs= statement.executeQuery(query);

            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                int year=rs.getInt(3);
                String lang=rs.getString(4);
                double rate=rs.getDouble(5);

                Film film=new Film(id,name,year,lang,rate);
                filmList.add(film);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    return filmList;
    }

    @Override
    public String getMovieName(int id) {
        String query="select filmName from filmInfo where filmId=?";
        String name="";
        try {
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet rs=pstmt.executeQuery();
            rs.next();
             name=rs.getString(1);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return name;
    }

    @Override
    public List<Film> displayMovies() {
        String query="select * from filmInfo";
        List<Film> filmList=new ArrayList<>();
        try {
            Statement statement=connection.createStatement();
            ResultSet rs= statement.executeQuery(query);

            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                int year=rs.getInt(3);
                String lang=rs.getString(4);
                double rate=rs.getDouble(5);

                Film film=new Film(id,name,year,lang,rate);
                filmList.add(film);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return filmList;
    }
}
