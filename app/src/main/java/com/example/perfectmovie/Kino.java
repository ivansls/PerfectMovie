package com.example.perfectmovie;

import java.util.ArrayList;

public class Kino {

    public int kinopoiskId;
    public String imdbId;
    public String nameRu;
    public Object nameEn;
    public String nameOriginal;
    public ArrayList<Country> countries;
    public ArrayList<Genre> genres;
    public double ratingKinopoisk;
    public double ratingImdb;
    public int year;
    public String type;
    public String posterUrl;
    public String posterUrlPreview;

    public class Country{
        public String country;
    }

    public class Genre{
        public String genre;
    }

}
