package com.example.perfectmovie;


import java.util.ArrayList;

public class InfoRoot {
    public int kinopoiskId;
    public String kinopoiskHDId;
    public String imdbId;
    public String nameRu;
    public Object nameEn;
    public String nameOriginal;
    public String posterUrl;
    public String posterUrlPreview;
    public String coverUrl;
    public String logoUrl;
    public int reviewsCount;
    public int ratingGoodReview;
    public int ratingGoodReviewVoteCount;
    public double ratingKinopoisk;
    public int ratingKinopoiskVoteCount;
    public double ratingImdb;
    public int ratingImdbVoteCount;
    public double ratingFilmCritics;
    public int ratingFilmCriticsVoteCount;
    public Object ratingAwait;
    public int ratingAwaitCount;
    public Object ratingRfCritics;
    public int ratingRfCriticsVoteCount;
    public String webUrl;
    public int year;
    public int filmLength;
    public String slogan;
    public String description;
    public String shortDescription;
    public Object editorAnnotation;
    public boolean isTicketsAvailable;
    public Object productionStatus;
    public String type;
    public String ratingMpaa;
    public String ratingAgeLimits;
    public ArrayList<Country> countries;
    public ArrayList<Genre> genres;
    public Object startYear;
    public Object endYear;
    public boolean serial;
    public boolean shortFilm;
    public boolean completed;
    public boolean hasImax;
    public boolean has3D;



    public class Country{
        public String country;
    }

    public class Genre{
        public String genre;
    }

}

