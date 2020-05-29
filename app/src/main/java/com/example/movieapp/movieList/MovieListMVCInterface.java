package com.example.movieapp.movieList;

import com.example.movieapp.RoomDB.MovieItem;
import com.example.movieapp.RoomDB.MovieItemEntity;
import com.example.movieapp.views.ObservableViewMvc;

import java.util.List;

public interface MovieListMVCInterface extends ObservableViewMvc<MovieListMVCInterface.Listener> {
    interface Listener{
        void onClick();
    }

    void bindData(List <MovieItemEntity> movieItems);

}
