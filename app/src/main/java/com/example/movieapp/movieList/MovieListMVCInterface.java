package com.example.movieapp.movieList;

import com.example.movieapp.views.ObservableViewMvc;

public interface MovieListMVCInterface extends ObservableViewMvc<MovieListMVCInterface.Listener> {
    public interface Listener{
        void onChange();
    }

    void bindData();

}
