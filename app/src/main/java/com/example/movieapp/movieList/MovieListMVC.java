package com.example.movieapp.movieList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.PureDI.MVCViewFactory;
import com.example.movieapp.R;
import com.example.movieapp.views.BaseObservableViewMvc;
import com.example.movieapp.views.ObservableViewMvc;

public class MovieListMVC extends BaseObservableViewMvc<MovieListMVCInterface.Listener> implements MovieListMVCInterface{


    private RecyclerView recyclerView;


    public MovieListMVC(LayoutInflater layoutInflater, ViewGroup viewGroup, MVCViewFactory viewFactory) {

        setRootView(layoutInflater.inflate(R.layout.activity_main,viewGroup));

        recyclerView = findViewById(R.id.movieList);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(layoutInflater,viewFactory);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerAdapter);


    }



    // bind data from activity to movie list
    @Override
    public void bindData() {

    }
}
