package com.example.movieapp.movieList;

import com.example.movieapp.model.MovieItemSchema;
import com.example.movieapp.views.ObservableViewMvc;

import java.util.List;

public interface MovieListUseCaseInter extends ObservableViewMvc<MovieListUseCaseInter.Listener> {


         interface Listener{
            void moviesSuccess(List<MovieItemSchema> movieItems);
        }

       void getMovieList();


}


