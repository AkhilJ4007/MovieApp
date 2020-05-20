package com.example.movieapp.movieList;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;


import com.example.movieapp.PureDI.RunnableFactory;
import com.example.movieapp.model.MovieItem;
import com.example.movieapp.model.MovieItemSchema;
import com.example.movieapp.model.MovieResponseSchema;
import com.example.movieapp.model.MovieService;
import com.example.movieapp.views.BaseObservableViewMvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListUseCase extends BaseObservableViewMvc<MovieListUseCaseInter.Listener>implements MovieListUseCaseInter {


    private MovieService movieService;
    private  volatile List<MovieItemSchema> movieItemSchemas = new ArrayList<>();
    private  RunnableFactory runnableFactory;


    public MovieListUseCase(MovieService movieService, RunnableFactory runnableFactory) {

        this.movieService = movieService;
        this.runnableFactory = runnableFactory;


    }

    // called from activity
    @Override
    public void getMovieList() {
        movieService.listMovies("daca1350ce3f8d413aa422f7367623cb").enqueue(new Callback<MovieResponseSchema>() {
            @Override
            public void onResponse(Call<MovieResponseSchema> call, Response<MovieResponseSchema> response) {
                notifyActivity(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieResponseSchema> call, Throwable t) {

            }
        });


    }

    public void notifyActivity( List<MovieItemSchema> movieItemSchemas){


        if(movieItemSchemas.size()>0) {

            Runnable listRunnable = runnableFactory.getListRunnable(movieItemSchemas,getListeners());

            new Thread(listRunnable).start();
        }


    }






}
