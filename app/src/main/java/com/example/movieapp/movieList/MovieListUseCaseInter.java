package com.example.movieapp.movieList;

import com.example.movieapp.model.MovieItem;
import com.example.movieapp.model.MovieItemSchema;
import com.example.movieapp.views.ObservableViewMvc;

import java.util.List;

public interface MovieListUseCaseInter extends ObservableViewMvc<MovieListUseCaseInter.Listener> {


        public interface Listener{
            void moviesSuccess(List<MovieItem> movieItems);
        }

       void getMovieList();


}


