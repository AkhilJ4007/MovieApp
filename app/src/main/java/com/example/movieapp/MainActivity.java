package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.movieapp.movieList.MovieListMVC;
import com.example.movieapp.movieList.MovieListMVCInterface;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutInflater = LayoutInflater.from(this);
        MovieListMVCInterface movieListMVCInterface = new MovieListMVC(layoutInflater,null);
        setContentView(movieListMVCInterface.getRootView());



    }


}
