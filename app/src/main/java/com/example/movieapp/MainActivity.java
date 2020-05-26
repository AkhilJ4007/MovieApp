package com.example.movieapp;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.movieapp.BaseClasses.BaseActivity;
import com.example.movieapp.PureDI.MVCViewFactory;
import com.example.movieapp.RoomDB.MovieDatabase;
import com.example.movieapp.RoomDB.MovieItemEntity;
import com.example.movieapp.ViewModel.MovieViewModel;
import com.example.movieapp.model.MovieService;

import com.example.movieapp.movieList.MovieListMVC;
import com.example.movieapp.movieList.MovieListMVCInterface;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends BaseActivity implements MovieListMVC.Listener{


    MovieListMVCInterface movieListMVCInterface;
    MovieViewModel viewModel;
    MovieDatabase movieDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MVCViewFactory viewfactory = getCompositionRoot().getMVCViewFactory();
        movieListMVCInterface = viewfactory.getMovieListMVC(null);
        movieListMVCInterface.registerListener(this);
        setContentView(movieListMVCInterface.getRootView());
        viewModel = getCompositionRoot().getViewModelFactory().create(MovieViewModel.class);
        // testing db
        testDB();
        //viewModel.getMovieList().observe(this, movieItems -> movieListMVCInterface.bindData(movieItems));
    }

    private void testDB() {

        MovieDBTask mTask = new MovieDBTask(MovieDatabase.getDB(this));
        mTask.execute();


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

       viewModel.getMovieList();


    }

    //movie list listener
    @Override
    public void onClick() {
        Log.d("click","clickkeddd!!");
    }

    public class MovieDBTask extends AsyncTask<Void,Void,String>{

        MovieDatabase movieDatabase;
        List<MovieItemEntity> movieItemEntities = new ArrayList<>();
        MovieItemEntity[] movieItemEntities1;

        public MovieDBTask(MovieDatabase movieDatabase) {
            this.movieDatabase = movieDatabase;
            movieItemEntities.add(new MovieItemEntity(123, "movieee", "123", "dfdsadfvsfvs", "dfwsdwdsd"));
            movieItemEntities.add(new MovieItemEntity(1244, "eerws", "123", "dfdsadfvsfvs", "dfwsdwdsd"));
            movieItemEntities.add(new MovieItemEntity(1242, "uiop", "123", "dfdsadfvsfvs", "dfwsdwdsd"));
            movieItemEntities1 = new MovieItemEntity[movieItemEntities.size()];

            movieItemEntities.toArray(movieItemEntities1);
            Log.d("ss",movieItemEntities1[2].getTitle());

        }



        @Override
        protected String doInBackground(Void... voids) {
            String s;
            //movieDatabase.movieDAO().insertMovie(new MovieItemEntity(123, "movieee", "123", "dfdsadfvsfvs", "dfwsdwdsd"));

            movieDatabase.movieDAO().insertAllMovies(movieItemEntities1);
            s = movieDatabase.movieDAO().getMoviesList().get(1).getTitle();
            return s;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("s",s);
        }
    }


}
