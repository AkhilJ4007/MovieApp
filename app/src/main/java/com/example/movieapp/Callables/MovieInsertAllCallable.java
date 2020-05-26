package com.example.movieapp.Callables;

import com.example.movieapp.RoomDB.MovieDatabase;
import com.example.movieapp.RoomDB.MovieItem;
import com.example.movieapp.RoomDB.MovieItemEntity;

import java.util.List;
import java.util.concurrent.Callable;

public class MovieInsertAllCallable implements Callable<Void> {

    MovieDatabase movieDatabase;
    List<MovieItem> movieItems;


    public MovieInsertAllCallable(MovieDatabase movieDatabase, List<MovieItem> movieItems) {
        this.movieDatabase = movieDatabase;
        this.movieItems = movieItems;
    }


    @Override
    public Void call() throws Exception {
        for(MovieItem movieItem:movieItems) {
            movieDatabase.movieDAO().insertMovie(new MovieItemEntity(movieItem.getId(),movieItem.getTitle(),movieItem.getReleaseDate(),movieItem.getOverview(),movieItem.getPosterPath()));
        }
        return null;
    }
}
