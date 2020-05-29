package com.example.movieapp;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.Observer;

import com.example.movieapp.BaseClasses.BaseActivity;
import com.example.movieapp.PureDI.MVCViewFactory;
import com.example.movieapp.RoomDB.MovieDatabase;
import com.example.movieapp.RoomDB.MovieItemEntity;
import com.example.movieapp.ViewModel.MovieViewModel;
import com.example.movieapp.model.MovieService;

import com.example.movieapp.movieList.MovieListMVC;
import com.example.movieapp.movieList.MovieListMVCInterface;


import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends BaseActivity implements MovieListMVC.Listener{


    MovieListMVCInterface movieListMVCInterface;
    MovieViewModel viewModel;
    MovieDatabase movieDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MVCViewFactory viewfactory = getCompositionRoot().getMVCViewFactory();
        movieListMVCInterface = viewfactory.getMovieListMVC(null);
        movieListMVCInterface.registerListener(this);
        setContentView(movieListMVCInterface.getRootView());
        viewModel = getCompositionRoot().getViewModelFactory().create(MovieViewModel.class);

        viewModel.getMovieList().observe(this, new Observer<List<MovieItemEntity>>() {
            @Override
            public void onChanged(List<MovieItemEntity> movieItemEntities) {
                //Log.d("in activity",movieItemEntities.get(0).getTitle());
                movieListMVCInterface.bindData(movieItemEntities);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieService service = retrofit.create(MovieService.class);
        Log.d("movie",retrofit.toString());

       viewModel.getMovieList();


    }

    //movie list listener
    @Override
    public void onClick() {
        Log.d("click","clickkeddd!!");
    }




}
