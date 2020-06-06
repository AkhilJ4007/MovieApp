package com.example.movieapp.MovieSimilarList;


import com.example.movieapp.views.ObservableViewMvc;

public interface SimilarItemInter extends ObservableViewMvc<SimilarItemInter.Listener> {

    interface Listener{
        void onClick();
    }

    void bindData();
}
