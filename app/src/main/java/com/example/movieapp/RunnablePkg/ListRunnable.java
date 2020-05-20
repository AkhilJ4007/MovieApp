package com.example.movieapp.RunnablePkg;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.movieapp.model.MovieItem;
import com.example.movieapp.model.MovieItemSchema;
import com.example.movieapp.movieList.MovieListUseCaseInter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

    public class ListRunnable implements Runnable{

        List<MovieItemSchema> movieItemSchema = new ArrayList<>();
        List<MovieListUseCaseInter.Listener> listeners = new ArrayList<>();
        private Handler uiHandler;

        public ListRunnable(List<MovieItemSchema> movieItems, Set<MovieListUseCaseInter.Listener> listeners,Handler uiHandler) {
            this.movieItemSchema.addAll(movieItems);
            this.listeners.addAll(listeners);
            this.uiHandler = uiHandler;
        }



        @Override
        public void run() {
            String title;
            List<MovieItem> movieItems = new ArrayList<>();



            for(MovieItemSchema movieItemSchema:movieItemSchema){


                if(movieItemSchema.getTitle()!= null){
                    title = movieItemSchema.getTitle();
                }
                else {
                    title = movieItemSchema.getName();
                }


                movieItems.add(new MovieItem(movieItemSchema.getId(),title,movieItemSchema.getReleaseDate(),movieItemSchema.getOverview(),movieItemSchema.getPosterPath()));

            }

            if(movieItems.size()>0) {

                uiHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("in ui thread","in ui thread");
                        for (MovieListUseCaseInter.Listener listener : listeners) {
                            Log.d("notifyActivity", "in here bui");
                            listener.moviesSuccess(movieItems);

                        }

                    }
                });


            }


        }
    }

