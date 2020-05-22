package com.example.movieapp;

import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.movieapp.BaseClasses.BaseActivity;
import com.example.movieapp.PureDI.MVCViewFactory;
import com.example.movieapp.PureDI.RunnableFactory;
import com.example.movieapp.model.MovieItem;
import com.example.movieapp.model.MovieService;

import com.example.movieapp.movieList.MovieListMVC;
import com.example.movieapp.movieList.MovieListMVCInterface;
import com.example.movieapp.movieList.MovieListUseCase;
import com.example.movieapp.movieList.MovieListUseCaseInter;

import java.util.List;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends BaseActivity implements MovieListMVC.Listener,MovieListUseCaseInter.Listener{


    MovieListMVCInterface movieListMVCInterface;
    MovieListUseCaseInter movieListUseCaseInter;
    RunnableFactory runnableFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MVCViewFactory viewfactory = getCompositionRoot().getMVCViewFactory();
        movieListMVCInterface = viewfactory.getMovieListMVC(null);
        movieListMVCInterface.registerListener(this);
        runnableFactory = getCompositionRoot().getRunnableFactory();
        movieListUseCaseInter = new MovieListUseCase(getCompositionRoot().getMovieService(),runnableFactory);
        movieListUseCaseInter.registerListener(this);
        setContentView(movieListMVCInterface.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieService service = retrofit.create(MovieService.class);
        Log.d("movie",retrofit.toString());

       movieListUseCaseInter.getMovieList();


    }

    //movie list listener
    @Override
    public void onClick() {
        Log.d("click","clickkeddd!!");
    }


    @Override
    public void moviesSuccess(List<MovieItem> movieItems) {


        movieListMVCInterface.bindData(movieItems);

    }
}
