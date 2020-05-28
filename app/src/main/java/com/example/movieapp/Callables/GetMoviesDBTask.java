package com.example.movieapp.Callables;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.movieapp.RoomDB.MovieDatabase;
import com.example.movieapp.RoomDB.MovieItemEntity;

import java.util.List;

public class GetMoviesDBTask extends AsyncTask<Void,Void, LiveData<List<MovieItemEntity>>> {

    MovieDatabase movieDatabase;
    Listener listener;

    public  interface Listener{
        void gotMovieListfromDB(LiveData<List<MovieItemEntity>> movieItemEntities);
    }

    public GetMoviesDBTask(MovieDatabase movieDatabase, Listener listener) {
        this.movieDatabase = movieDatabase;
        this.listener = listener;
    }

    @Override
    protected LiveData<List<MovieItemEntity>> doInBackground(Void... voids) {
        return movieDatabase.movieDAO().getMoviesList();
    }

    @Override
    protected void onPostExecute(LiveData<List<MovieItemEntity>> movieItemEntities) {
        super.onPostExecute(movieItemEntities);
        listener.gotMovieListfromDB(movieItemEntities);
    }
}
