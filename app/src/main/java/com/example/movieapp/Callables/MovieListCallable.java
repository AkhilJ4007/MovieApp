package com.example.movieapp.Callables;

import com.example.movieapp.RoomDB.MovieItem;
import com.example.movieapp.RoomDB.MovieItemEntity;
import com.example.movieapp.model.MovieItemSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MovieListCallable implements Callable<List<MovieItemEntity>> {


private List<MovieItemSchema> movieItemSchemas;

    public MovieListCallable(List<MovieItemSchema> movieItemList) {
        this.movieItemSchemas = movieItemList;
    }

    @Override
    public List<MovieItemEntity> call(){

        String title;
        List<MovieItemEntity> movieItems = new ArrayList<>();



        for(MovieItemSchema movieItemSchema:movieItemSchemas){


            if(movieItemSchema.getTitle()!= null){
                title = movieItemSchema.getTitle();
            }
            else {
                title = movieItemSchema.getName();
            }


            movieItems.add(new MovieItemEntity(movieItemSchema.getId(),title,movieItemSchema.getReleaseDate(),movieItemSchema.getOverview(),movieItemSchema.getBackdropPath()));

        }


        return movieItems;
    }
}
