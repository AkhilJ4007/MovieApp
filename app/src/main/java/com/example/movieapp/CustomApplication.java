package com.example.movieapp;

import android.app.Application;

import com.example.movieapp.PureDI.CompositionRoot;
import com.example.movieapp.model.MovieService;

public class CustomApplication extends Application {

    private CompositionRoot compositionRoot;


    @Override
    public void onCreate() {
        super.onCreate();
        compositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot(){

    return compositionRoot;

    }





}
