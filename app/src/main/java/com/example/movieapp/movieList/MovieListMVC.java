package com.example.movieapp.movieList;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.PureDI.MVCViewFactory;
import com.example.movieapp.R;
import com.example.movieapp.RoomDB.MovieItem;
import com.example.movieapp.views.BaseObservableViewMvc;

import java.util.List;

public class MovieListMVC extends BaseObservableViewMvc<MovieListMVCInterface.Listener> implements MovieListMVCInterface,RecyclerAdapter.Listener{


    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;


    public MovieListMVC(LayoutInflater layoutInflater, ViewGroup viewGroup, MVCViewFactory viewFactory) {

        setRootView(layoutInflater.inflate(R.layout.activity_main,viewGroup));

        recyclerView = findViewById(R.id.movieList);
        recyclerAdapter = new RecyclerAdapter(layoutInflater,viewFactory,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerAdapter);


    }
    //movie list binds data
    @Override
    public void bindData(List <MovieItem> movieItems) {

//        Log.d("in movieList",movieItems.get(0).getTitle());
        recyclerAdapter.bindData(movieItems);
    }

    //click from adapter

    @Override
    public void onClick() {

        for (Listener listener:getListeners()){
            listener.onClick();
        }


    }


    //Recycler Adapter


}
