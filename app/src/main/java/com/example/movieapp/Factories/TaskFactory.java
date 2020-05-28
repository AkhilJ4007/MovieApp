package com.example.movieapp.Factories;

import com.example.movieapp.Callables.GetMoviesDBTask;
import com.example.movieapp.Callables.InsertMoviesDBTask;
import com.example.movieapp.RoomDB.MovieDatabase;
import com.example.movieapp.RoomDB.MovieItemEntity;

import java.util.List;

public class TaskFactory {


    public InsertMoviesDBTask getInsertMoviesDBTask(MovieDatabase movieDatabase, List<MovieItemEntity> movieItemEntities){
        InsertMoviesDBTask mTask = new InsertMoviesDBTask(movieDatabase, movieItemEntities);
        return mTask;
    }

    public GetMoviesDBTask getMoviesDBTask(MovieDatabase movieDatabase, GetMoviesDBTask.Listener listener){
        GetMoviesDBTask mTask = new GetMoviesDBTask(movieDatabase,listener);
        return mTask;
    }
}
