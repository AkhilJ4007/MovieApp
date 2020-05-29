package com.example.movieapp.Repository;

import android.util.Log;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.movieapp.Callables.GetMoviesDBTask;
import com.example.movieapp.Factories.TaskFactory;
import com.example.movieapp.RoomDB.MovieDatabase;
import com.example.movieapp.RoomDB.MovieItemEntity;
import com.example.movieapp.Threading.MovieExecutors;
import com.example.movieapp.RoomDB.MovieItem;


import java.util.List;

public class MovieRepo implements MovieExecutors.Listener, GetMoviesDBTask.Listener {

    private  MediatorLiveData<List<MovieItemEntity>> movieList = new MediatorLiveData<>();
    private MovieExecutors executors;
    private MediatorLiveData<List<MovieItemEntity>> chumma = new MediatorLiveData<>();
    private MovieDatabase movieDatabase;
    private  LifecycleOwner lifecycleOwner;
    TaskFactory taskFactory;

    public MovieRepo(MovieExecutors executors, MovieDatabase movieDatabase, TaskFactory taskFactory, LifecycleOwner lifecycleOwner) {
        this.executors = executors;
        this.movieDatabase = movieDatabase;
        this.taskFactory = taskFactory;
        this.lifecycleOwner = lifecycleOwner;
        executors.registerListener(this);

    }

    public void getMovieListsWeb(){
        executors.getMovies();
    }

    public void fetchData(){
        getMoviesfromDB();
        getMovieListsWeb();
    }

    public MediatorLiveData<List<MovieItemEntity>> getMovieList(){
        return movieList;
    }

    private void getMoviesfromDB() {
        taskFactory.getMoviesDBTask(movieDatabase,this).execute();

    }

    // from retrofit call
    @Override
    public void movieListSuccess(List<MovieItemEntity> movieItems) {

        //movieList.postValue(movieItems);
       Log.d("movieListSuccess",movieItems.get(0).getTitle());
        if(movieItems != null) {
            if (movieItems.size() > 0) {
                taskFactory.getInsertMoviesDBTask(movieDatabase, movieItems).execute();
            }
        }
    }

    // from getMovieList DB Task
    @Override
    public void gotMovieListfromDB(LiveData<List<MovieItemEntity>> movieItemEntities) {


        movieItemEntities.observe(lifecycleOwner, new Observer<List<MovieItemEntity>>() {
            @Override
            public void onChanged(List<MovieItemEntity> movieItemEntities) {
               movieList.postValue(movieItemEntities);
            }
        });

    }
}
