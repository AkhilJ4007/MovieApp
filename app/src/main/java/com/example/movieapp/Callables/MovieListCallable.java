package com.example.movieapp.Callables;

import com.example.movieapp.model.MovieItem;
import com.example.movieapp.model.MovieItemSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MovieListCallable implements Callable<List<MovieItem>> {


private List<MovieItemSchema> movieItemSchemas;

    public MovieListCallable(List<MovieItemSchema> movieItemList) {
        this.movieItemSchemas = movieItemList;
    }

    @Override
    public List<MovieItem> call(){

        String title;
        List<MovieItem> movieItems = new ArrayList<>();



        for(MovieItemSchema movieItemSchema:movieItemSchemas){


            if(movieItemSchema.getTitle()!= null){
                title = movieItemSchema.getTitle();
            }
            else {
                title = movieItemSchema.getName();
            }


            movieItems.add(new MovieItem(movieItemSchema.getId(),title,movieItemSchema.getReleaseDate(),movieItemSchema.getOverview(),movieItemSchema.getPosterPath()));

        }


        return movieItems;
    }
}
