package com.example.perfectmovie;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Apiinterface {
    @Headers("X-API-KEY: 1372c186-8ffb-44c3-905a-1a5c0baaf6fc")
    @GET("v2.2/films/{id}")
    Call<InfoRoot> getFilmInfo(@Path("id") int id);

    @Headers("X-API-KEY: 1372c186-8ffb-44c3-905a-1a5c0baaf6fc")
    @GET("v1/staff")
    Call<ArrayList<AuthorRoot>> getAuthor(@Query("filmId") String id);

    @Headers("X-API-KEY: 1372c186-8ffb-44c3-905a-1a5c0baaf6fc")
    @GET("v2.2/films/{id}/videos")
    Call<VideoRoot> getVideo(@Path("id") int id);


    @Headers("X-API-KEY: 1372c186-8ffb-44c3-905a-1a5c0baaf6fc")
    @GET("v2.2/films/collections?type=TOP_250_MOVIES&page=1")
    Call<Root1> getTopFilms();


    @Headers("X-API-KEY: 1372c186-8ffb-44c3-905a-1a5c0baaf6fc")
    @GET("v2.1/films/releases?year=2024&month=JANUARY&page=1")
    Call<RootExpended> getExpectedFilms();



}
