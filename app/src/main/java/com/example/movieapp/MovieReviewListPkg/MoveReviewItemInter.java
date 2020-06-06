package com.example.movieapp.MovieReviewListPkg;


import com.example.movieapp.views.ObservableViewMvc;

public interface MoveReviewItemInter extends ObservableViewMvc<MoveReviewItemInter.Listener> {
    interface Listener{
        void onClick();
    }

    void bindQuestions();
}
