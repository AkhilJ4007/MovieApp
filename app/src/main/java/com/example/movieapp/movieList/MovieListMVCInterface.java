package com.example.movieapp.movieList;

import com.example.movieapp.model.MovieItem;
import com.example.movieapp.views.ObservableViewMvc;

import java.util.List;

public interface MovieListMVCInterface extends ObservableViewMvc<MovieListMVCInterface.Listener> {
    interface Listener{
        void onClick();
    }

    void bindData(List <MovieItem> movieItems);

}
