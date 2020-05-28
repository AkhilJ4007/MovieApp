package com.example.movieapp.Callables;

import android.os.AsyncTask;
import android.util.Log;

import com.example.movieapp.RoomDB.MovieDatabase;
import com.example.movieapp.RoomDB.MovieItemEntity;

import java.util.ArrayList;
import java.util.List;

public class InsertMoviesDBTask extends AsyncTask<Void,Void,Void> {

    MovieDatabase movieDatabase;
    List<MovieItemEntity> movieItemEntities = new ArrayList<>();
    MovieItemEntity[] movieItemEntities1;

    public InsertMoviesDBTask(MovieDatabase movieDatabase, List<MovieItemEntity> movieItemEntities) {
        this.movieDatabase = movieDatabase;
       this.movieItemEntities = movieItemEntities;
        movieItemEntities1 = new MovieItemEntity[movieItemEntities.size()];

        movieItemEntities.toArray(movieItemEntities1);
       // Log.d("in dbinsertask",movieItemEntities1[0].getTitle());

    }



    @Override
    protected Void doInBackground(Void... voids) {
        String s;
        //movieDatabase.movieDAO().insertMovie(new MovieItemEntity(123, "movieee", "123", "dfdsadfvsfvs", "dfwsdwdsd"));
        //s = movieItemEntities1[0].getTitle();
        movieDatabase.movieDAO().insertAllMovies(movieItemEntities1);
        return null;
    }



}