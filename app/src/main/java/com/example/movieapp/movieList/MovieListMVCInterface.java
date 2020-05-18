package com.example.movieapp.movieList;

import com.example.movieapp.views.ObservableViewMvc;

public interface MovieListMVCInterface extends ObservableViewMvc<MovieListMVCInterface.Listener> {
    interface Listener{
        void onClick();
    }

    void bindData(String s);

}
