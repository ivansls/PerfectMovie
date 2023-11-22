package com.example.perfectmovie;

import java.util.ArrayList;

public class Release {
    public int filmId;
    public String nameRu;
    public String nameEn;
    public int year;
    public String posterUrl;
    public String posterUrlPreview;
    public ArrayList<Country> countries;
    public ArrayList<Genre> genres;
    public Object rating;
    public int ratingVoteCount;
    public double expectationsRating;
    public int expectationsRatingVoteCount;
    public int duration;
    public String releaseDate;

    public class Country{
        public String country;
    }

    public class Genre{
        public String genre;
    }
}
