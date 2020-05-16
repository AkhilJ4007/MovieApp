package com.example.movieapp.movieList;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.movieapp.R;
import com.example.movieapp.views.BaseObservableViewMvc;
import com.example.movieapp.views.ObservableViewMvc;

public class MovieListMVC extends BaseObservableViewMvc<MovieListMVCInterface.Listener> implements MovieListMVCInterface{

    LayoutInflater layoutInflater;

    public MovieListMVC(LayoutInflater layoutInflater, ViewGroup viewGroup) {

        setRootView(layoutInflater.inflate(R.layout.activity_main,viewGroup));
    }

    @Override
    public void bindData() {

    }
}
