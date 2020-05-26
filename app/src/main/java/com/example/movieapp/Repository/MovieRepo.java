package com.example.movieapp.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.Threading.MovieExecutors;
import com.example.movieapp.RoomDB.MovieItem;

import java.util.List;

public class MovieRepo implements MovieExecutors.Listener {

    private  MutableLiveData<List<MovieItem>> movieList = new MutableLiveData<>();
    private MovieExecutors executors;

    public MovieRepo(MovieExecutors executors) {
        this.executors = executors;
        executors.registerListener(this);

    }

    public MutableLiveData<List<MovieItem>> getMovieLists(){
        executors.getMovies();
        return movieList;
    }


    @Override
    public void movieListSuccess(List<MovieItem> movieItems) {
       movieList.postValue(movieItems);
    }
}
