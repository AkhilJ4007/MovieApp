package com.example.movieapp.PureDI;

import com.example.movieapp.model.MovieItem;
import com.example.movieapp.model.MovieResponseSchema;
import com.example.movieapp.model.MovieService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot {

    private Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public MovieService getMovieService(){
       return getRetrofit().create(MovieService.class);
    }

    public RunnableFactory getRunnableFactory(){
        return new RunnableFactory();
    }





}
