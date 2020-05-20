package com.example.movieapp.PureDI;

import android.os.Handler;
import android.os.Looper;

import com.example.movieapp.RunnablePkg.ListRunnable;
import com.example.movieapp.model.MovieItemSchema;
import com.example.movieapp.movieList.MovieListUseCase;
import com.example.movieapp.movieList.MovieListUseCaseInter;

import java.util.List;
import java.util.Set;


public class RunnableFactory {

    private Handler uiHandler;
    private Handler getUIThread()
    {
        if(uiHandler == null) {
             uiHandler = new android.os.Handler(Looper.getMainLooper());
        }
        return uiHandler;
    }

    public ListRunnable getListRunnable(List<MovieItemSchema> movieItems, Set<MovieListUseCaseInter.Listener> listeners){
        return new ListRunnable(movieItems,listeners,getUIThread());
    }

}
