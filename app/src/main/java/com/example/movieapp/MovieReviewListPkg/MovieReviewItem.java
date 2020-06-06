package com.example.movieapp.MovieReviewListPkg;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.horizontalrecyclerview.R;
import com.example.horizontalrecyclerview.views.BaseObservableViewMvc;

public class MovieReviewItem extends BaseObservableViewMvc<MoveReviewItemInter.Listener> implements MoveReviewItemInter {
    //from adapter
    @Override
    public void bindQuestions() {

    }


    public MovieReviewItem(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        setRootView(layoutInflater.inflate(R.layout.movie_review_item,viewGroup,false));

    }
}
