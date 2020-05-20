package com.example.movieapp.movieList;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.movieapp.model.MovieItem;
import com.example.movieapp.model.MovieItemSchema;
import com.example.movieapp.model.MovieResponseSchema;
import com.example.movieapp.model.MovieService;
import com.example.movieapp.views.BaseObservableViewMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListUseCase extends BaseObservableViewMvc<MovieListUseCaseInter.Listener>implements MovieListUseCaseInter {


    private MovieService movieService;
    private  volatile List<MovieItemSchema> movieItemSchemas = new ArrayList<>();
    private Handler uiHandler = new Handler(Looper.getMainLooper());

    public MovieListUseCase(MovieService movieService) {

        this.movieService = movieService;


    }

    // called from activity
    @Override
    public void getMovieList() {
        movieService.listMovies("daca1350ce3f8d413aa422f7367623cb").enqueue(new Callback<MovieResponseSchema>() {
            @Override
            public void onResponse(Call<MovieResponseSchema> call, Response<MovieResponseSchema> response) {


                Log.d("inResponse",response.body().getResults().get(0).getTitle());


                   notifyActivity(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieResponseSchema> call, Throwable t) {

            }
        });


    }

    public void notifyActivity( List<MovieItemSchema> movieItemSchemas){



//        String title;
//        List<MovieItem> movieItems = new ArrayList<>();
//
//
//        for(MovieItemSchema movieItemSchema:movieItemSchemas){
//            if(movieItemSchema.getTitle()!= null){
//                title = movieItemSchema.getTitle();
//            }
//            else {
//                title = movieItemSchema.getName();
//            }
//
//
//            movieItems.add(new MovieItem(movieItemSchema.getId(),title,movieItemSchema.getReleaseDate(),movieItemSchema.getOverview(),movieItemSchema.getPosterPath()));
//
//        }
//
//        if(movieItems.size()>0) {
//
//            for (Listener listener : getListeners()) {
//                Log.d("notifyActivity", "in here bui");
//                listener.moviesSuccess(movieItems);
//
//            }

//        }

        if(movieItemSchemas.size()>0) {

            Runnable listRunnable = new ListRunnable(movieItemSchemas, getListeners());

            new Thread(listRunnable).start();
        }


    }


    public class ListRunnable implements Runnable{

        List<MovieItemSchema> movieItemSchema = new ArrayList<>();

        public ListRunnable(List<MovieItemSchema> movieItems, Set<Listener> listeners) {
            this.movieItemSchema.addAll(movieItems);
        }

        @Override
        public void run() {
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

            if(movieItems.size()>0) {

                uiHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("in ui thread","in ui thread");
                        for (Listener listener : getListeners()) {
                            Log.d("notifyActivity", "in here bui");
                            listener.moviesSuccess(movieItems);

                        }

                    }
                });


            }


        }
    }



}
