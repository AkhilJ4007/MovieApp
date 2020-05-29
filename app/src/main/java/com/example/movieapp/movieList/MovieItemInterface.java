package com.example.movieapp.movieList;

import com.example.movieapp.RoomDB.MovieItemEntity;
import com.example.movieapp.views.ObservableViewMvc;

public interface MovieItemInterface extends ObservableViewMvc<MovieItemInterface.Listener> {

    interface Listener{
        void onClick();
    }
    void bindMovies(MovieItemEntity movieItemEntity);
}
