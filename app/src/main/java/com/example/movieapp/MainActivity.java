package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.movieapp.BaseClasses.BaseActivity;
import com.example.movieapp.PureDI.MVCViewFactory;
import com.example.movieapp.movieList.MovieListMVC;
import com.example.movieapp.movieList.MovieListMVCInterface;


public class MainActivity extends BaseActivity {

    RecyclerView recyclerView;
    LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MVCViewFactory viewfactory = getCompositionRoot().getMVCViewFactory();
        MovieListMVCInterface movieListMVCInterface = viewfactory.getMovieListMVC(null);
        setContentView(movieListMVCInterface.getRootView());



    }


}
