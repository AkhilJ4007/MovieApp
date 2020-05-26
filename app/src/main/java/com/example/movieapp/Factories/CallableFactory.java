package com.example.movieapp.Factories;

import com.example.movieapp.Callables.MovieListCallable;
import com.example.movieapp.model.MovieItemSchema;

import java.util.List;

public class CallableFactory {

    public MovieListCallable getListCallable(List<MovieItemSchema> movieItems){

        return new MovieListCallable(movieItems);

    }


}
