package com.example.movieapp.movieList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;
import com.example.movieapp.views.BaseObservableViewMvc;
import com.example.movieapp.views.ObservableViewMvc;

public class MovieListMVC extends BaseObservableViewMvc<MovieListMVCInterface.Listener> implements MovieListMVCInterface{

    LayoutInflater layoutInflater;
    RecyclerView recyclerView;

    public MovieListMVC(LayoutInflater layoutInflater, ViewGroup viewGroup, Context context) {

        setRootView(layoutInflater.inflate(R.layout.activity_main,viewGroup));

        recyclerView = findViewById(R.id.movieList);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(layoutInflater);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(recyclerAdapter);


    }



    // bind data from activity to movie list
    @Override
    public void bindData() {

    }
}
