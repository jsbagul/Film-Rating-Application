package org.UI;

import org.DAO.Service;
import org.DAO.ServiceImple;
import org.DTO.Film;

import java.util.List;
import java.util.Scanner;

public class MainApp
{
    static Scanner scanner=new Scanner(System.in);
    static Service service=new ServiceImple();

    public static void main( String[] args )
    {
        System.out.println("=============================");
        System.out.println("select Mode of Operation");
        System.out.println("1. Add film");
        System.out.println("2. Update film year");
        System.out.println("3. display all the films details whose rating are impressive");
        System.out.println("4. See top 5 movie to get good chance nominating to oscar award");
        System.out.println("5. display All movie details");
        System.out.println("6. exit");
        int choise= scanner.nextInt();
        switch (choise){
            case 1:
                    giveRatingToFilm();
                    break;
            case 2:
                    updatefilmYear();
                    break;
            case 3:
                    displayGoodfilm();
                    break;
            case 4:
                     oscarGosTo();
                    break;
            case 5:
                    displayAllMovie();
                    break;
            case 6:
                    System.exit(0);
                    break;
            default:
                System.out.println("Invalid Input");
                break;

        }
        main(args);
    }

    private static void displayAllMovie() {
        System.out.println("filmId \t fimlName \t year \tlang \t ratting");
        for (Film f : service.displayMovies()) {
            System.out.println(f.getFilmId()+"\t\t"+f.getFilmName()+"\t\t"+f.getFilmYear()+"\t"+f.getFimlLang()+"\t"+f.getFilmRating());

        }
    }

    private static void oscarGosTo() {
        System.out.println("-------------------------------------------");
        System.out.println("filmId \t fimlName \t year \tlang \t ratting");
        for (Film f : service.nominate()) {
            System.out.println(f.getFilmId()+"\t"+f.getFilmName()+"\t"+f.getFilmYear()+"\t"+f.getFimlLang()+"\t"+f.getFilmRating());

        }
    }

    private static void displayGoodfilm() {
        System.out.println("-------------------------------------------");
        System.out.println("filmId \t fimlName \t year \tlang \t ratting");
        for (Film f: service.goodFilms() ) {
            System.out.println(f.getFilmId()+"\t"+f.getFilmName()+"\t"+f.getFilmYear()+"\t"+f.getFimlLang()+"\t"+f.getFilmRating());

        }
    }

    private static void updatefilmYear() {
        System.out.println("Enter Film Year");
        int fYear=scanner.nextInt();
        System.out.println("Enter Film name");
        scanner.nextLine();
        String fName=scanner.nextLine();

       int rowAffect= service.updateFilmYear(fYear,fName);
        if (rowAffect==1)
            System.out.println("Film year Updated");
        else
            System.out.println("Something went Wrong");

    }

    private static void giveRatingToFilm() {
        System.out.println("Enter Film name");
        scanner.nextLine();
        String name=scanner.nextLine();
        System.out.println("Enter Film Year");
        int year=scanner.nextInt();
        System.out.println("Enter Film lang");
        String lang=scanner.next();
        System.out.println("Enter Film ratting");
        double rate=scanner.nextDouble();
        Film film=new Film(name,year,lang,rate);

        int rowAffect=service.giveRating(film);
        if (rowAffect==1)
            System.out.println("Film added");
        else
            System.out.println("Something went Wrong");

    }
}
