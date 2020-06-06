package com.example.movieapp.MovieDetails;


import com.example.movieapp.views.ObservableViewMvc;

public interface MovieDetailsMVCInter extends ObservableViewMvc<MovieDetailsMVCInter.Listener> {
     interface Listener{
         void OnClick();
    }
    void bindData();
}
