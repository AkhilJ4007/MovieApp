package com.example.movieapp.Threading;

import com.example.movieapp.Factories.CallableFactory;
import com.example.movieapp.model.MovieItem;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MovieExecutors {

    private CallableFactory callableFactory;
    private Executor executor = Executors.newFixedThreadPool(5);

    public MovieExecutors(CallableFactory callableFactory) {
        this.callableFactory = callableFactory;
    }

    public List<MovieItem> getLists(){

    }


}
