package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.movieapp.BaseClasses.BaseActivity;
import com.example.movieapp.PureDI.MVCViewFactory;
import com.example.movieapp.movieList.MovieListMVC;
import com.example.movieapp.movieList.MovieListMVCInterface;


public class MainActivity extends BaseActivity implements MovieListMVC.Listener{

    RecyclerView recyclerView;
    LayoutInflater layoutInflater;
    MovieListMVCInterface movieListMVCInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MVCViewFactory viewfactory = getCompositionRoot().getMVCViewFactory();
        movieListMVCInterface = viewfactory.getMovieListMVC(null);
        movieListMVCInterface.registerListener(this);
        setContentView(movieListMVCInterface.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        movieListMVCInterface.bindData("YIPEEEE!!!");

    }


    //movie list listener

    @Override
    public void onChange() {

    }
}
