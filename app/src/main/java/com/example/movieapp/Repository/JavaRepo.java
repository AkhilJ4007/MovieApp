package com.example.movieapp.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.Threading.MovieExecutors;
import com.example.movieapp.Wrapper.Resource;
import com.example.movieapp.model.MovieItem;

import java.util.List;

public class JavaRepo {

    private MutableLiveData<Resource<List<MovieItem>>> movieList= new MutableLiveData<>();
    private MovieExecutors executors;

    public JavaRepo(MovieExecutors executors) {
        this.executors = executors;

    }

    public void getMovieList(){



    }


}
