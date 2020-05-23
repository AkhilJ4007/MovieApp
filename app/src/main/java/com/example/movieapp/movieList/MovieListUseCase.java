package com.example.movieapp.movieList;

import android.util.Log;


import com.example.movieapp.model.MovieItemSchema;
import com.example.movieapp.model.MovieResponseSchema;
import com.example.movieapp.model.MovieService;
import com.example.movieapp.views.BaseObservableViewMvc;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListUseCase extends BaseObservableViewMvc<MovieListUseCaseInter.Listener>implements MovieListUseCaseInter {


    private MovieService movieService;
    private  volatile List<MovieItemSchema> movieItemSchemas = new ArrayList<>();
    public MovieListUseCase(MovieService movieService) {

        this.movieService = movieService;

    }

    // called from activity
    @Override
    public void getMovieList() {
        movieService.listMovies("daca1350ce3f8d413aa422f7367623cb").enqueue(new Callback<MovieResponseSchema>() {
            @Override
            public void onResponse(Call<MovieResponseSchema> call, Response<MovieResponseSchema> response) {
                Log.d("nootify List",response.body().getResults().get(0).getTitle());
                notifyListeners(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieResponseSchema> call, Throwable t) {

            }
        });


    }

    private void notifyListeners(List<MovieItemSchema> results) {
        if(results.size()>0) {
            for(Listener listener: getListeners()){
                Log.d("nootify List","in here");
                listener.moviesSuccess(results);
            }
        }

    }







}
